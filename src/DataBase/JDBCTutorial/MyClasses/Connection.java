package DataBase.JavaDocs.JDBCBasics;

import java.sql.SQLException;

/**
 * Created by Nikhil on 2/6/2017 6:25 PM.
 */
public class Connection {
    public static void main(String[] args) throws SQLException {
        Connection connection = new Connection();
        String dbName = "mySql";
        viewTable(connection, dbName);
    }
    public static void viewTable(Connection connection,  String dbName) throws SQLException{

    }
}
