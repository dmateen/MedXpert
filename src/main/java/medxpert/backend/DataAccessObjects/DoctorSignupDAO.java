package medxpert.backend.DataAccessObjects;


import medxpert.backend.POJOS.Doctor;
import medxpert.backend.POJOS.Patient;

import java.sql.*;

public class DoctorSignupDAO {
    // -------- Declaring JDBC Vars --------
    String url;
    Connection con;
    Statement st;
    // -------- //Declaring JDBC Vars --------

    // -------- Default Constructor --------
    public DoctorSignupDAO() throws Exception {

        // -------- JDBC Connection --------
        Class.forName("com.mysql.jdbc.Driver");
        url = "jdbc:mysql://127.0.0.1/medxpert";
        con = DriverManager.getConnection(url, "root", "root");
        st = con.createStatement();
        // -------- //JDBC Connection --------

    }
    // -------- //Default Constructor --------
    public void addDoctor(Doctor doctor) throws SQLException {

        /** Getting DB Connection **/
//        dbConnection.openConnection();
//        Connection con=dbConnection.getConnection();

        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("INSERT INTO doctor " +
                "(doctorID,FirstName,LastName,DateOfBirth,UserName,CNIC,PhoneNo,Password) " +
                "values(?,?,?,?,?,?,?,?) ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,doctor.getDoctorId());
        preSt.setString(2,doctor.getFirstName());
        preSt.setString(3,doctor.getLastName());
        preSt.setString(4,doctor.getDateOfBirth());
        preSt.setString(5,doctor.getUserName());
        preSt.setString(6,doctor.getCNIC());
        preSt.setString(7,doctor.getPhoneNumber());
        preSt.setString(8,doctor.getPassword());

        System.out.println(preSt);

        /** Executing Query **/
        preSt.executeUpdate();


        /** Closing DB Connection **/
//        dbConnection.closeConnection();
    }
}
