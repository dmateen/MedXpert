package medxpert.backend.resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import medxpert.backend.POJOS.Doctor;
import medxpert.backend.POJOS.Patient;
import medxpert.backend.backendFiles.DoctorService;
import medxpert.backend.backendFiles.PatientService;

import javax.print.Doc;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/endPoint")
public class MedXpert_Resources {

    @GET
    @Path("/entry")
    public String entry() throws Exception {
        return "Connection Established";
    }

    @POST
    @Path("/signupPatient")
    public Response signupPatient(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        /**---- Sending Data to PatinetSignUpService -----**/
        PatientService patientService =new PatientService(patient);

        return Response.ok().build();
    }

    @POST
    @Path("/signupDoctor")
    public Response signupDoctor(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload, Doctor.class);

        /**---- Sending Data to DoctorSignUpService -----**/
        DoctorService doctorSignupService=new DoctorService(doctor);

        return Response.ok("Signed Up").build();
    }

    @POST
    @Path("/getPatientAdult")
    public Response getPatientAdult(String payload) throws Exception {

        /**---- Sending Data to PatientSignUpService -----**/
        PatientService patientService=new PatientService();

        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        Patient p=patientService.getPatient(patient.getCNIC());

        String json=new Gson().toJson(p);

        return Response.ok(json).build();
    }

    @POST
    @Path("/getPatientMinor")
    public Response getPatientMinor(String payload) throws Exception {

        /**---- Sending Data to PatientSignUpService -----**/
        PatientService patientService=new PatientService();

        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        /**---- Getting Data From DB -----**/
        Patient p=patientService.getPatientMinor(patient.getUserName());

        String json=new Gson().toJson(p);

        return Response.ok(json).build();
    }

    @POST
    @Path("/getDoctor")
    public Response getDoctor(String payload) throws Exception {

        /**---- Sending Data to Doctor Service -----**/
        DoctorService doctorService=new DoctorService();

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload,Doctor.class);

        /**---- Getting Data From DB -----**/
        Doctor d=doctorService.getDoctor(doctor.getCNIC());

        String json=new Gson().toJson(d);

        return Response.ok(json).build();
    }

}
