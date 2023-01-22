package medxpert.backend;

import medxpert.backend.POJOS.Patient;
import medxpert.backend.backendFiles.PatientService;

public class Main {
    public static void main(String [] args) throws Exception {
        Patient p=new Patient();
//        p.setPatientId("abx");
//        p.setFirstName("ab");
//        p.setLastName("sds");
        p.setUserName("Helloorlda");
        PatientService patientSignupService=new PatientService(p);
        patientSignupService.getPatientMinor(p.getCNIC());
//        p.setPhoneNumber("sjdfs");
//        p.setDateOfBirth("sfsss");
//
//        PatientSignupService patientSignupService=new PatientSignupService(p);
    }
}
