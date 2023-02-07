package medxpert.backend.backendFiles;
import medxpert.backend.DataAccessObjects.DoctorSignupDAO;
import medxpert.backend.DataAccessObjects.PatientSignupDAO;
import medxpert.backend.POJOS.Doctor;

import javax.print.Doc;
import java.util.UUID;

public class DoctorService {
    Doctor doctor;

    public DoctorService(Doctor d) throws Exception {
        doctor=d;

        //Add Id to the Doctor
        doctor.setDoctorId(createDoctorID());
        doctor=setDateFormat(doctor);

        //Validate Patient

        //Add Doctor to DB
        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();
        doctorSignupDAO.addDoctor(doctor);
    }
    public DoctorService(){
        
    }
    private String createDoctorID()
    {
        return "PAT-"+ UUID.randomUUID().toString().substring(0,6);
    }

    public Doctor getDoctor(String cnic) throws Exception {

        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();

        return DoctorSignupDAO.getDoctor(cnic);
    }

    public Doctor loginDoctor(Doctor doctor) throws Exception {
        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();

        return DoctorSignupDAO.loginDoctor(doctor);
    }


    public boolean checkDuplicateCNIC(String cnic) throws Exception {
        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();
        return doctorSignupDAO.checkDuplicateCNIC(cnic);
    }

    public boolean checkDuplicateUsername(String username) throws Exception {
        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();
        return doctorSignupDAO.checkDuplicateUsername(username);
    }

    private Doctor setDateFormat(Doctor doctor){
        String date=doctor.getDateOfBirth();

        String dateArr[]=date.split("-");
        doctor.setDateOfBirth(dateArr[2]+"-"+dateArr[1]+"-"+dateArr[0]);

        return doctor;

    }


    public void updateProfile(Doctor doctor) throws Exception {
        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();
        doctor=setDateFormat(doctor);
        doctorSignupDAO.updateDoctorProfile(doctor);
    }
}
