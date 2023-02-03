package medxpert.backend.DataAccessObjects;


import medxpert.backend.POJOS.Doctor;
import medxpert.backend.POJOS.Patient;

import java.sql.*;

public class DoctorSignupDAO {
    // -------- Declaring JDBC Vars --------
    String url;
    static Connection con;
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


    public static Doctor getDoctor(String cnic) throws SQLException {
        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("SELECT * FROM doctor " +
                "WHERE CNIC=? ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,cnic);


        /** Executing Query **/
        ResultSet rs= preSt.executeQuery();

        /** Creating Patient from Query Data **/
        Doctor doctor=new Doctor();
        while(rs.next()) {
            //doctor.setID();
            doctor.setDoctorId(rs.getString("doctorID"));
            doctor.setFirstName(rs.getString("FirstName"));
            doctor.setLastName(rs.getString("LastName"));
            doctor.setDateOfBirth(rs.getString("DateOfBirth"));
            doctor.setUserName(rs.getString("UserName"));
            doctor.setCNIC(rs.getString("CNIC"));
            doctor.setPhoneNumber(rs.getString("PhoneNo"));
            doctor.setGender(rs.getString("Gender"));
            doctor.setEmail(rs.getString("Email"));
            doctor.setSpecialist(rs.getString("Specialist"));
            doctor.setArea(rs.getString("Area"));
            doctor.setCity(rs.getString("City"));
            doctor.setCountry(rs.getString("Country"));
        }
        System.out.println(doctor);
        return doctor;
    }

    public static boolean loginDoctor(Doctor doctor) throws SQLException {


        //Giving Internal server error when cnic is uses


        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("SELECT * FROM doctor " +
                "WHERE (CNIC=? OR USERNAME=?) AND password_=?");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,doctor.getCNIC());
        preSt.setString(2,doctor.getUserName());
        preSt.setString(3,doctor.getPassword());

        System.out.println(preSt);

        ResultSet rs= preSt.executeQuery();

        if(rs.next())
            return true;
        else
            return false;
    }
}
