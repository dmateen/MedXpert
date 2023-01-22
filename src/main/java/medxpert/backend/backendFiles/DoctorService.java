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

        //Validate Patient

        //Add Patient to DB
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
}
