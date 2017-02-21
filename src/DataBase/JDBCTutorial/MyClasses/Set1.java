package DataBase.JDBCTutorial.MyClasses;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Nikhil on 2/6/2017 6:25 PM.
 */
public class Set1 {
    public String dbName;
    public Connection connection;
    public String dbms;

    public Set1(String dbName, Connection connection, String dbms) {
        super();
        this.dbName = dbName;
        this.connection = connection;
        this.dbms = dbms;
    }

    //first get connection.
    private static Connection getConnection() throws SQLException {
        Connection connection = null;
        Connection connection1 = null;      //for testing only.

        //here we need to have Username and Password.
        String userName = "root";
        String password = "root";
        String dbms = "mysql";
        String serverName = "localhost";
        int portNumber = 3307;

        //create properties object for storing username and password
        Properties properties = new Properties();
        properties.put("user", userName);
        properties.put("password", password);

        if (dbms.equals("mysql")) {
            connection =        //pass the URL to getConnection method.
                    DriverManager.getConnection(                //1.DriverManager.getConnection function is used to make connection to the database.
                            "jdbc:" + dbms + "://"          //2. Or DataSource Interface object is used to establish a connection.
                                    + serverName + ":" + portNumber
                                    + "/" + properties);
            //or directly hardCode;
            connection1 = DriverManager.getConnection(                //1.DriverManager.getConnection function is used to make connection to the database.
                    "jdbc:mysql://localhost:3307/" + properties);

            //to just connect to a database without using username and password.
            //"jdbc:mysql://localhost:3307/databaseName );
        } else if (dbms.equals("derby")) {
            /*  There can be different types of URLs for different database types.
                1.MySQL     :   jdbc:mysql://localhost:3306/,
                                where localhost is the name of the server hosting your database,
                                and 3306 is the port number
                2.Java DB   :   jdbc:derby:testdb;create=true,
                                where testdb is the name of the database to connect to,
                                and create=true instructs the DBMS to create the database.

                .At last with URL we need username and password
                .hence use Properties object to store it
                .and append it to the URL.

            */
        }
        System.out.println("Connected To the database");
        return connection;
    }


    //executing query using connection object.
    public static void viewTable(Connection connection, String dbName) throws SQLException {
        String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from" + dbName + "COFFEES";
        //Statement statement = null;            //here b/c otherwise cant test it in finally due to score
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String coffeeName = resultSet.getNString(1);
                int supplierId = resultSet.getInt(2);
                float price = resultSet.getFloat(3);
                int sales = resultSet.getInt(4);
                int total = resultSet.getInt(5);
                System.out.println(coffeeName + "\t" + supplierId + "\t" + price + "\t" + sales + "\t" + total);
            }
        } finally {
            //when try(condition for error checking) is used then inside this() is automatically closed.
            //if(statement!=null) statement.close();
        }
    }


    public static void createTable(Connection connection) throws SQLException {
        String query = "create table COFFEES " + "(COF_NAME varchar(32) NOT NULL, " +
                "SUP_ID int NOT NULL, " + "PRICE numeric(10,2) NOT NULL, " +
                "SALES integer NOT NULL, " + "TOTAL integer NOT NULL, " +
                "PRIMARY KEY (COF_NAME), " +
                "FOREIGN KEY (SUP_ID) REFERENCES SUPPLIERS (SUP_ID))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }


    public static void main(String[] args) throws SQLException {
        Connection connection;
        /*step 1*/
        connection = getConnection();
        /*step 2*/
        createTable(connection);
        /*step 3*/
        viewTable(connection, "mysql");
    }
}