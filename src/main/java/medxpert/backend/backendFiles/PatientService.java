package medxpert.backend.backendFiles;
import medxpert.backend.DataAccessObjects.PatientSignupDAO;
import medxpert.backend.POJOS.Doctor;
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
        patient=setDateFormat(patient);
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

    public Patient loginPatinet(Patient patient) throws Exception {
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();
        return patientSignupDAO.loginpatient(patient);
    }

    public boolean checkDuplicateCNIC(String cnic) throws Exception {
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();
        return patientSignupDAO.checkDuplicateCNIC(cnic);
    }

    public boolean checkDuplicateUsername(String username) throws Exception {
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();
        return patientSignupDAO.checkDuplicateUsername(username);
    }

    private Patient setDateFormat(Patient patient){
        String date=patient.getDateOfBirth();
        String dateArr[]=date.split("-");
        patient.setDateOfBirth(dateArr[2]+"-"+dateArr[1]+"-"+dateArr[0]);
        return patient;

    }

    public void updateProfile(Patient patient) throws Exception {
        PatientSignupDAO patientSignupDAO=new PatientSignupDAO();
        patient=setDateFormat(patient);
        patientSignupDAO.updateProfile(patient);
    }
}
