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

        /** Getting DB Connection **/
//        dbConnection.openConnection();
//        Connection con=dbConnection.getConnection();

        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("INSERT INTO patient " +
                "(patientID,FirstName,LastName,DateOfBirth,CNIC,PhoneNo,UserName) " +
                "values(?,?,?,?,?,?,?) ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,patient.getPatientId());
        preSt.setString(2,patient.getFirstName());
        preSt.setString(3,patient.getLastName());
        preSt.setString(4,patient.getDateOfBirth());
        preSt.setString(5,patient.getCNIC());
        preSt.setString(6,patient.getPhoneNumber());
        preSt.setString(7,patient.getUserName());

        System.out.println(preSt);

        /** Executing Query **/
        preSt.executeUpdate();


        /** Closing DB Connection **/
//        dbConnection.closeConnection();
    }

    public Patient getPatinet(String cnic) throws SQLException {

        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("SELECT * FROM patient " +
                "WHERE CNIC=? ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,cnic);

        System.out.println(preSt);

        /** Executing Query **/
        ResultSet rs= preSt.executeQuery();

        /** Creating Patient from Query Data **/
        Patient patient=new Patient();
        while(rs.next()) {
            //patient.setID();
            patient.setPatientId(rs.getString("patientID"));
            patient.setFirstName(rs.getString("FirstName"));
            patient.setLastName(rs.getString("LastName"));
            patient.setDateOfBirth(rs.getString("DateOfBirth"));
            patient.setUserName(rs.getString("UserName"));
            patient.setCNIC(rs.getString("CNIC"));
            patient.setPhoneNumber(rs.getString("PhoneNo"));
            patient.setGender(rs.getString("Gender"));
            patient.setBloodGroup(rs.getString("BloodGroup"));
            patient.setArea(rs.getString("Area"));
            patient.setCity(rs.getString("City"));
            patient.setCountry(rs.getString("Country"));
        }
        System.out.println(patient);
        return patient;

    }

    public Patient getPatinetMinor(String userName) throws SQLException {

        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("SELECT * FROM patient " +
                "WHERE UserName=? ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,userName);

        System.out.println(preSt);

        /** Executing Query **/
        ResultSet rs= preSt.executeQuery();

        /** Creating Patient from Query Data **/
        Patient patient=new Patient();
        while(rs.next()) {
            //patient.setID();
            patient.setPatientId(rs.getString("patientID"));
            patient.setFirstName(rs.getString("FirstName"));
            patient.setLastName(rs.getString("LastName"));
            patient.setDateOfBirth(rs.getString("DateOfBirth"));
            patient.setUserName(rs.getString("UserName"));
            patient.setCNIC(rs.getString("CNIC"));
            patient.setPhoneNumber(rs.getString("PhoneNo"));
            patient.setGender(rs.getString("Gender"));
            patient.setBloodGroup(rs.getString("BloodGroup"));
            patient.setArea(rs.getString("Area"));
            patient.setCity(rs.getString("City"));
            patient.setCountry(rs.getString("Country"));
        }
        System.out.println(patient);
        return patient;

    }
}
