package medxpert.backend.backendFiles;
import medxpert.backend.DataAccessObjects.DoctorSignupDAO;
import medxpert.backend.DataAccessObjects.PatientSignupDAO;
import medxpert.backend.POJOS.Doctor;
import medxpert.backend.POJOS.Patient;

import java.sql.SQLException;
import java.util.UUID;

public class DoctorSignupService {
    Doctor doctor;

    public DoctorSignupService(Doctor d) throws Exception {
        doctor=d;

        //Add Id to the Doctor
        doctor.setDoctorId(createDoctorID());

        //Validate Patient

        //Add Patient to DB
        DoctorSignupDAO doctorSignupDAO=new DoctorSignupDAO();
        doctorSignupDAO.addDoctor(doctor);
    }

    private String createDoctorID()
    {
        return "PAT-"+ UUID.randomUUID().toString().substring(0,6);
    }

}
