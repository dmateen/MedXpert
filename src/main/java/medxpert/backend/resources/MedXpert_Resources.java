package medxpert.backend.resources;

import com.google.gson.Gson;
import medxpert.backend.POJOS.Doctor;
import medxpert.backend.POJOS.Patient;
import medxpert.backend.backendFiles.DoctorSignupService;
import medxpert.backend.backendFiles.PatientSignupService;

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
        PatientSignupService patientSignupService=new PatientSignupService(patient);

        return Response.ok().build();
    }

    @POST
    @Path("/signupDoctor")
    public Response signupDoctor(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload, Doctor.class);

        /**---- Sending Data to DoctorSignUpService -----**/
        DoctorSignupService patientSignupService=new DoctorSignupService(doctor);

        return Response.ok("Signed Up").build();
    }



}
