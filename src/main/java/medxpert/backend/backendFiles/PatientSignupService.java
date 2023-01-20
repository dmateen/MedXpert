package medxpert.backend.backendFiles;
import medxpert.backend.DataAccessObjects.PatientSignupDAO;
import medxpert.backend.POJOS.Patient;

import java.sql.SQLException;
import java.util.UUID;

public class PatientSignupService {
    Patient patient;

    public PatientSignupService(Patient p) throws Exception {
        patient=p;

        //Add Id to the Patient
        patient.setPatientId(createPatientID());

        //Validate Patient

        //Add Patient to DB
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();
        patientSignupDAO.addPatient(patient);
    }

    private String createPatientID()
    {
        return "PAT-"+ UUID.randomUUID().toString().substring(0,6);
    }

}
