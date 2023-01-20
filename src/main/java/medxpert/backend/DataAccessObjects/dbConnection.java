package medxpert.backend.DataAccessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {
    // -------- Declaring JDBC Vars --------
    static String url="jdbc:mysql://127.0.0.1/medxpert";
    static Connection con;
    // -------- //Declaring JDBC Vars --------

    // -------- Default Constructor --------
    public dbConnection() throws Exception {

        // -------- JDBC Connection --------
        Class.forName("com.mysql.jdbc.Driver");
        url = "jdbc:mysql://127.0.0.1/medxpert";

        // -------- //JDBC Connection --------

    }

    public static Connection getConnection() {
        return con;
    }

    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url, "root", "root");
    }

    public static void closeConnection() throws SQLException
    {
        con.close();
    }
}
