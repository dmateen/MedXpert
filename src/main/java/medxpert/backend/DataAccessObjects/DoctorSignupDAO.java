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
                "(doctorID,FirstName,LastName,DateOfBirth,UserName,CNIC,PhoneNo,Password_) " +
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

    public static Doctor loginDoctor(Doctor doctor) throws SQLException {


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
        boolean check=rs.next();

        if(!check)
            return new Doctor();

        Doctor doctor1=new Doctor();
        doctor1.setDoctorId(rs.getString("doctorId"));
        doctor1.setFirstName(rs.getString("FirstName"));
        doctor1.setLastName(rs.getString("LastName"));
        doctor1.setDateOfBirth(rs.getString("DateOfBirth"));
        doctor1.setUserName(rs.getString("UserName"));
        doctor1.setCNIC(rs.getString("CNIC"));
        doctor1.setPhoneNumber(rs.getString("PhoneNo"));
        doctor1.setGender(rs.getString("Gender"));
        doctor1.setEmail(rs.getString("Email"));
        doctor1.setSpecialist(rs.getString("Specialist"));
        doctor1.setArea(rs.getString("Area"));
        doctor1.setCity(rs.getString("City"));
        doctor1.setCountry(rs.getString("Country"));
        doctor1.setPassword(rs.getString("Password_"));


        return doctor1;
//        if(rs.next())
//            return true;
//        else
//            return false;
    }

    public boolean checkDuplicateCNIC(String cnic) throws SQLException {
        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("SELECT * FROM doctor " +
                "WHERE CNIC=? ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,cnic);

        System.out.println(preSt);

        ResultSet rs= preSt.executeQuery();

        if(rs.next())
            return true;
        else
            return false;
    }

    public boolean checkDuplicateUsername(String username) throws SQLException {
        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("SELECT * FROM doctor " +
                "WHERE USERNAME=? ");

        /** Adding Prepared Statement Data **/
        preSt.setString(1,username);

        System.out.println(preSt);

        ResultSet rs= preSt.executeQuery();

        if(rs.next())
            return true;
        else
            return false;
    }

    public void updateDoctorProfile(Doctor doctor) throws SQLException {

        /** Creating Prepared Statement **/
        PreparedStatement preSt = con.prepareStatement("Update doctor " +
                "Set FirstName=?,LastName=?,DateOfBirth=?,UserName=?,CNIC=?,PhoneNo=?,Gender=?,Email=?, Specialist=?, Area=?, City=?, Country=?,Password_=?"+

                "Where CNIC=?");

        /** Adding Prepared Statement Data **/

        preSt.setString(1,doctor.getFirstName());
        preSt.setString(2,doctor.getLastName());
        preSt.setString(3,doctor.getDateOfBirth());
        preSt.setString(4,doctor.getUserName());
        preSt.setString(5,doctor.getCNIC());
        preSt.setString(6,doctor.getPhoneNumber());
        preSt.setString(7,doctor.getGender());
        preSt.setString(8,doctor.getEmail());
        preSt.setString(9,doctor.getSpecialist());
        preSt.setString(10,doctor.getArea());
        preSt.setString(11,doctor.getCity());
        preSt.setString(12,doctor.getCountry());
        preSt.setString(13,doctor.getPassword());
        preSt.setString(14,doctor.getCNIC());

        System.out.println(preSt);

        /** Executing Query **/
        preSt.executeUpdate();



    }
}
