package medxpert.backend.DataAccessObjects;


import medxpert.backend.POJOS.Patient;

import java.sql.*;

public class PatientSignupDAO {
    // -------- Declaring JDBC Vars --------
    String url;
    Connection con;
    Statement st;
    // -------- //Declaring JDBC Vars --------

    // -------- Default Constructor --------
    public PatientSignupDAO() throws Exception {

        // -------- JDBC Connection --------
        Class.forName("com.mysql.jdbc.Driver");
        url = "jdbc:mysql://127.0.0.1/medxpert";
        con = DriverManager.getConnection(url, "root", "root");
        st = con.createStatement();
        // -------- //JDBC Connection --------

    }
    // -------- //Default Constructor --------
    public void addPatient(Patient patient) throws SQLException {


        System.out.println("Printing Patient in PATIENT DAO");
        System.out.println(patient);

        /** Getting DB Connection **/
//        dbConnection.openConnection();
//        Connection con=dbConnection.getConnection();

        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("INSERT INTO patient " +
                "(patientID,FirstName,LastName,DateOfBirth,CNIC,PhoneNo) " +
                "values(?,?,?,?,?,?) ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,patient.getPatientId());
        preSt.setString(2,patient.getFirstName());
        preSt.setString(3,patient.getLastName());
        preSt.setString(4,patient.getDateOfBirth());
        preSt.setString(5,patient.getPhoneNumber());
        preSt.setString(6,patient.getPhoneNumber());

        System.out.println(preSt);

        /** Executing Query **/
        preSt.executeUpdate();


        /** Closing DB Connection **/
//        dbConnection.closeConnection();
    }
}
