package medxpert.backend.POJOS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Doctor {
    String doctorId;
    String FirstName;
    String LastName;
    String DateOfBirth;
    String UserName;
    String CNIC;
    String PhoneNumber;
    String Gender;
    String Email;
    String Specialist;
    String Area;
    String City;
    String Country;
    String Password;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String specialist) {
        Specialist = specialist;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", UserName='" + UserName + '\'' +
                ", CNIC='" + CNIC + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Email='" + Email + '\'' +
                ", Specialist='" + Specialist + '\'' +
                ", Area='" + Area + '\'' +
                ", City='" + City + '\'' +
                ", Country='" + Country + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
