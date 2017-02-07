package DataBase.JDBCTutorial.MyClasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nikhil on 2/6/2017 6:25 PM.
 */
public class Set1 {
    private String dbName;
    private Connection connnection;
    private String dbms;

    public Set1(String dbName, Connection connection, String dbms) {
        this.dbName = dbName;
        this.connnection = connection;
        this.dbms = dbms;
    }

    public static void viewTable(Connection connection, String dbName) throws SQLException {
        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from" + dbName + "COFFEES";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);


    }
}