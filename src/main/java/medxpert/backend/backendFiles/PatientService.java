package medxpert.backend.backendFiles;
import medxpert.backend.DataAccessObjects.PatientSignupDAO;
import medxpert.backend.POJOS.Patient;

import java.util.UUID;

public class PatientService {
    Patient patient;

    public PatientService()
    {

    }

    public PatientService(Patient p) throws Exception {
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

    public Patient getPatient(String CNIC) throws Exception {

        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();

        return patientSignupDAO.getPatinet(CNIC);


    }

    public Patient getPatientMinor(String userName) throws Exception {
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();

        return patientSignupDAO.getPatinetMinor(userName);
    }

    public boolean loginPatinet(Patient patient) throws Exception {
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();
        return patientSignupDAO.loginPatinet(patient);
    }
}
