

package DataBase.JDBCTutorial.src;
/*
import com.sun.rowset.CachedRowSetImpl;*/

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.spi.SyncProviderException;
import javax.sql.rowset.spi.SyncResolver;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CachedRowSetSample {

  private String dbName;
  private Connection con;
  private String dbms;
  private JDBCTutorialUtilities settings;


  public CachedRowSetSample(Connection connArg,
                            JDBCTutorialUtilities settingsArg) {
    super();
    this.con = connArg;
    this.dbName = settingsArg.dbName;
    this.dbms = settingsArg.dbms;
    this.settings = settingsArg;


  }

    public static void viewTable(Connection con) throws SQLException {
        Statement stmt = null;
        String query = "select * from MERCH_INVENTORY";
        try {
            stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Found item " + rs.getInt("ITEM_ID") + ": " +
                        rs.getString("ITEM_NAME") + " (" +
                        rs.getInt("QUAN") + ")");
            }

        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void main(String[] args) {
        JDBCTutorialUtilities myJDBCTutorialUtilities;
        Connection myConnection = null;

        if (args[0] == null) {
            System.err.println("Properties file not specified at command line");
            return;
        } else {
            try {
                myJDBCTutorialUtilities = new JDBCTutorialUtilities(args[0]);
            } catch (Exception e) {
                System.err.println("Problem reading properties file " + args[0]);
                e.printStackTrace();
                return;
            }
        }

        try {
            myConnection = myJDBCTutorialUtilities.getConnection();

            if (myJDBCTutorialUtilities == null) {
                System.out.println("myJDBCTU is null");
            }

            if (myConnection == null) {
                System.out.println("myConnection is null");
            }

            CachedRowSetSample myCachedRowSetSample =
                    new CachedRowSetSample(myConnection, myJDBCTutorialUtilities);
            viewTable(myConnection);
            myCachedRowSetSample.testPaging();


        } catch (SQLException e) {
            JDBCTutorialUtilities.printSQLException(e);
        } catch (Exception ex) {
            System.out.println("Unexpected exception");
            ex.printStackTrace();
        } finally {
            JDBCTutorialUtilities.closeConnection(myConnection);
        }
    }

  public void testPaging() throws SQLException, MalformedURLException {

    CachedRowSet crs = null;
    this.con.setAutoCommit(false);

    try {

      crs = null;/*new CachedRowSetImpl();*/
      crs.setUsername(settings.userName);
      crs.setPassword(settings.password);

      if (this.dbms.equals("mysql")) {
        crs.setUrl(settings.urlString + "?relaxAutoCommit=true");
      } else {
        crs.setUrl(settings.urlString);
      }
      crs.setCommand("select * from MERCH_INVENTORY");

      // Setting the page size to 4, such that we
      // get the data in chunks of 4 rows @ a time.
      crs.setPageSize(100);

      // Now get the first set of data
      crs.execute();

      crs.addRowSetListener(new ExampleRowSetListener());

      // Keep on getting data in chunks until done.

      int i = 1;
      do {
        System.out.println("Page number: " + i);
        while (crs.next()) {
          System.out.println("Found item " + crs.getInt("ITEM_ID") + ": " +
                             crs.getString("ITEM_NAME"));
          if (crs.getInt("ITEM_ID") == 1235) {
            int currentQuantity = crs.getInt("QUAN") + 1;
            System.out.println("Updating quantity to " + currentQuantity);
            crs.updateInt("QUAN", currentQuantity + 1);
            crs.updateRow();
            // Syncing the row back to the DB
            crs.acceptChanges(con);
          }


        } // End of inner while
        i++;
      } while (crs.nextPage());
      // End of outer while


      // Inserting a new row
      // Doing a previous page to come back to the last page
      // as we ll be after the last page.

      int newItemId = 123456;

      if (this.doesItemIdExist(newItemId)) {
        System.out.println("Item ID " + newItemId + " already exists");
      } else {
        crs.previousPage();
        crs.moveToInsertRow();
        crs.updateInt("ITEM_ID", newItemId);
        crs.updateString("ITEM_NAME", "TableCloth");
        crs.updateInt("SUP_ID", 927);
        crs.updateInt("QUAN", 14);
        Calendar timeStamp;
        timeStamp = new GregorianCalendar();
        timeStamp.set(2006, 4, 1);
        crs.updateTimestamp("DATE_VAL", new Timestamp(timeStamp.getTimeInMillis()));
        crs.insertRow();
        crs.moveToCurrentRow();

        // Syncing the new row back to the database.
        System.out.println("About to add a new row...");
        crs.acceptChanges(con);
        System.out.println("Added a row...");
          viewTable(con);
      }
    } catch (SyncProviderException spe) {

      SyncResolver resolver = spe.getSyncResolver();

      Object crsValue; // value in the RowSet object
      Object resolverValue; // value in the SyncResolver object
      Object resolvedValue; // value to be persisted

      while (resolver.nextConflict()) {

        if (resolver.getStatus() == SyncResolver.INSERT_ROW_CONFLICT) {
          int row = resolver.getRow();
          crs.absolute(row);

          int colCount = crs.getMetaData().getColumnCount();
          for (int j = 1; j <= colCount; j++) {
            if (resolver.getConflictValue(j) != null) {
              crsValue = crs.getObject(j);
              resolverValue = resolver.getConflictValue(j);

              // Compare crsValue and resolverValue to determine
              // which should be the resolved value (the value to persist)
              //
              // This example choses the value in the RowSet object,
              // crsValue, to persist.,

              resolvedValue = crsValue;

              resolver.setResolvedValue(j, resolvedValue);
            }
          }
        }
      }
    } catch (SQLException sqle) {
      JDBCTutorialUtilities.printSQLException(sqle);
    } finally {
      if (crs != null) crs.close();
      this.con.setAutoCommit(true);
    }

  }

  private boolean doesItemIdExist(int id) throws SQLException {

    Statement stmt = null;
    String query = "select ITEM_ID from MERCH_INVENTORY where ITEM_ID = " + id;
    try {
      stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery(query);

      if (rs.next()) {
        return true;
      }

    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    } finally {
      if (stmt != null) { stmt.close(); }
    }
    return false;

  }
}

