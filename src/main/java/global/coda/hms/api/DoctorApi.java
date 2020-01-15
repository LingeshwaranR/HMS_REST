package global.coda.hms.api;

import global.coda.hms.constant.applicationconstant.apiconstants.DoctorApiContants;
import global.coda.hms.delegate.DoctorDelegate;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.CustomResponse;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

import java.util.ResourceBundle;


/**
 * The type Doctor api.
 */
@Path("/api/doctor")
public class DoctorApi {
    /**
     * The Logger.
     */
    private Logger LOGGER = LogManager.getLogger(DoctorApi.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());


    /**
     * Instantiates a new Doctor api.
     */

    /**
     * Create patient response.
     *
     * @param email      the email
     * @param password   the password
     * @param username   the username
     * @param specialist the specialist
     * @return the response
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    @POST
    @Path("createdoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> createPatient(@FormParam("email") String email,
                                                @FormParam("password") String password,
                                                @FormParam("username") String username,
                                                @FormParam("specialist") String specialist

    ) throws SystemException, BuisnessException {

        //Create Service
//        JSONObject jsonObject = new JSONObject();
        LOGGER.entry( email + " " + password + " " + username + " " + specialist);
        CustomResponse<String> customResponse = new CustomResponse<>();
        String message = LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.SUCCESSFULLY_CREATED);


        DoctorDelegate.createDoctorDelegate(email, password, username, specialist);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Read patient custom response.
     *
     * @param userId the user id
     * @return the custom response
     * @throws BuisnessException the buisness exception
     */
    @POST
    @Path("readdoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<Doctor> readPatient(@FormParam("userId") int userId) throws BuisnessException, SystemException {

        //Read Service
        LOGGER.entry( userId);
        CustomResponse<Doctor> customResponse = new CustomResponse<>();
        Doctor doctor = DoctorDelegate.readDoctorDelegate(userId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(doctor);
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Update patient custom response.
     *
     * @param userId     the user id
     * @param email      the email
     * @param password   the password
     * @param username   the username
     * @param specialist the specialist
     * @return the custom response
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    @PUT
    @Path("updatedoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> updatePatient(@FormParam("userId") int userId,
                                                @FormParam("email") String email,
                                                @FormParam("password") String password,
                                                @FormParam("username") String username,
                                                @FormParam("specialist") String specialist
    ) throws SystemException, BuisnessException {
        LOGGER.entry(userId + email + " " + password + " " + username + " " + specialist);
        CustomResponse<String> customResponse = new CustomResponse<>();
        String message = LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.SUCCESSFULLY_UPDATED);


        DoctorDelegate.updateDoctorDelegate(userId, email, password, username, specialist);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    /**
     * Gets all patient.
     *
     * @param userId the dotor id
     * @return the all patient
     * @throws BuisnessException the buisness exception
     */

    @PUT
    @Path("deletedoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> deletePatient(@FormParam("userId") int userId) throws BuisnessException, SystemException {

        //Read Service
        LOGGER.entry( userId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        String message = LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.SUCCESSFULLY_DELETED);

        DoctorDelegate.deleteDoctorDelegate(userId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.traceExit(customResponse);
        return customResponse;
    }

    //FIX : CHECKSTYLE
    @POST
    @Path("{id}/getAllPatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    //FIX SPELLING MISTAKE
    //FIX : USE SYSTEM EXCEPTION
    public CustomResponse<List<Patient>> getAllPatient(@PathParam("id") int doctorId) throws BuisnessException, SystemException {

        //FIX : USE LOG4J TRACE ENTRY
        LOGGER.entry( doctorId);
        CustomResponse<List<Patient>> customResponse = new CustomResponse<>();
        List<Patient> patientList;
        //FIX : DO NOT DEFINE BEFORE USE
        //FIX FUNCTION NAME
        patientList = DoctorDelegate.getAllPatientUnderDoctorDelegate(doctorId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(patientList);
        //FIX : TRACE EXIT
        LOGGER.traceExit(customResponse);
        return customResponse;
    }
    @POST
    @Path("all/patient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<List<Doctor>> getAllDoctorsPatient() throws BuisnessException, SystemException {

        List<Doctor> doctorList;
        LOGGER.traceEntry();

        CustomResponse<List<Doctor>> customResponse = new CustomResponse<>();
        doctorList=DoctorDelegate.readAllDoctorsPatientsDelegate();
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(doctorList);
        LOGGER.traceExit(customResponse);
        return customResponse;
    }


}

