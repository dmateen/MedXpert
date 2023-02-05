package medxpert.backend.resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import medxpert.backend.POJOS.Doctor;
import medxpert.backend.POJOS.Patient;
import medxpert.backend.POJOS.ResponseJson;
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

        System.out.println(payload);

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload, Doctor.class);

        System.out.println(doctor.toString());

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

    @POST
    @Path("/testingPayload")
    public Response testingPayload(String payload) throws Exception {

        System.out.println(payload);

        return Response.ok("Han jee Chal rha hai").build();
    }

    @POST
    @Path("/loginPatient")
    public Response loginPatient(String payload) throws Exception {

        System.out.println(payload);
        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        /**---- Sending Data to PatientSignUpService -----**/
        PatientService patientService=new PatientService();

        System.out.println(patient.toString());
        /**---- Getting Data From DB -----**/
        Patient patient1=patientService.loginPatinet(patient);

        String json=new Gson().toJson(patient1);

        return Response.ok(json).build();
    }

    @POST
    @Path("/loginDoctor")
    public Response loginDoctor(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload,Doctor.class);

        /**---- Sending Data to PatientSignUpService -----**/
        DoctorService doctorService=new DoctorService();

        /**---- Getting Data From DB -----**/
        Doctor doctor1=doctorService.loginDoctor(doctor);

       String json=new Gson().toJson(doctor1);


        return Response.ok(json).build();
    }

    @POST
    @Path("/checkDuplicateCNICPatient")
    public Response checkDuplicateCNICPatient(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        /**---- Sending Data to PatientSignUpService -----**/
        PatientService patientService=new PatientService();

        /**---- Getting Data From DB -----**/
        boolean duplicate=patientService.checkDuplicateCNIC(patient.getCNIC());




        return Response.ok(duplicate).build();
    }

    @POST
    @Path("/checkDuplicateUsernamePatient")
    public Response checkDuplicateUsernamePatient(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        /**---- Sending Data to PatientSignUpService -----**/
        PatientService patientService=new PatientService();

        /**---- Getting Data From DB -----**/
        boolean duplicate=patientService.checkDuplicateUsername(patient.getUserName());

        return Response.ok(duplicate).build();
    }



    @POST
    @Path("/checkDuplicateCNICDoctor")
    public Response checkDuplicateCNICDoctor(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload,Doctor.class);

        /**---- Sending Data to PatientSignUpService -----**/
        DoctorService doctorService=new DoctorService();

        /**---- Getting Data From DB -----**/
        boolean duplicate=doctorService.checkDuplicateCNIC(doctor.getCNIC());



        return Response.ok(duplicate).build();
    }

    @POST
    @Path("/checkDuplicateUsernameDoctor")
    public Response checkDuplicateUsernameDoctor(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload,Doctor.class);

        /**---- Sending Data to PatientSignUpService -----**/
        DoctorService doctorService=new DoctorService();

        /**---- Getting Data From DB -----**/
        boolean duplicate=doctorService.checkDuplicateUsername(doctor.getUserName());

        return Response.ok(duplicate).build();
    }


    @POST
    @Path("/updateDoctorProfile")
    public Response updateDoctorProfile(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Doctor doctor=new Gson().fromJson(payload,Doctor.class);

        /**---- Sending Data to PatientSignUpService -----**/
        DoctorService doctorService=new DoctorService();

        /**---- Getting Data From DB -----**/
        doctorService.updateProfile(doctor);

        return Response.ok().build();
    }

    @POST
    @Path("/updatePatientProfile")
    public Response updatePatientProfile(String payload) throws Exception {

        /**---- Transferring Data from JSON to Class -----**/
        Patient patient=new Gson().fromJson(payload,Patient.class);

        /**---- Sending Data to PatientSignUpService -----**/
        PatientService patientService=new PatientService();

        /**---- Getting Data From DB -----**/
        patientService.updateProfile(patient);

        return Response.ok().build();
    }
}
