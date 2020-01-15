package global.coda.hms.api;

import global.coda.hms.constant.applicationconstant.apiconstants.PatientApiConstants;
import global.coda.hms.delegate.PatientDelegate;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.CustomResponse;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Patient api.
 */
@Path("/api/patient")
public class PatientApi {
    /**
     * The Logger.
     */
   private Logger LOGGER = LogManager.getLogger(PatientApi.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());

    private PatientDelegate patientDelegate = new PatientDelegate();

    /**
     * Instantiates a new Patient api.
     */

    /**
     * Create patient custom response.
     *
     * @param email    the email
     * @param password the password
     * @param username the username
     * @param age      the age
     * @param area     the area
     * @param city     the city
     * @param state    the state
     * @return the custom response
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    @POST
    @Path("createpatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> createPatient(@FormParam("email") String email,
                                                @FormParam("password") String password,
                                                @FormParam("username") String username,
                                                @FormParam("age") int age,
                                                @FormParam("area") String area,
                                                @FormParam("city") String city,
                                                @FormParam("state") String state
    ) throws SystemException, BuisnessException {

        //Create Service
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.ENTERED_PATIENTAPI_CREATE) + " "
                +
                email + " " + password + " " + username + " " + age + " " + area + " " + city + " " + state);
        CustomResponse<String> customResponse = new CustomResponse<>();
        String message = LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.SUCCESSFULLY_CREATED_PATIENT);


        patientDelegate.createPatientDelegate(email, password, username, age, area, city, state);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.PATIENT_CREATED_IN_PATIENTAPI));
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
    @Path("readpatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<Patient> readPatient(@FormParam("userId") int userId) throws BuisnessException {

        //Read Service
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.ENTERED_PATIENTAPI_READ) + " userId : " + userId);
        CustomResponse<Patient> customResponse = new CustomResponse<>();
        Patient patient = new Patient();
        patient = patientDelegate.readPatientDelegate(userId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(patient);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.PATIENT_READ_IN_PATIENTAPI));
        return customResponse;
    }

    /**
     * Update patient custom response.
     *
     * @param email    the email
     * @param password the password
     * @param username the username
     * @param age      the age
     * @param area     the area
     * @param city     the city
     * @param state    the state
     * @param userId   the user id
     * @return the custom response
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    @PUT
    @Path("updatepatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> updatePatient(@FormParam("email") String email,
                                                @FormParam("password") String password,
                                                @FormParam("username") String username,
                                                @FormParam("age") int age,
                                                @FormParam("area") String area,
                                                @FormParam("city") String city,
                                                @FormParam("state") String state,
                                                @FormParam("userId") int userId

    ) throws SystemException, BuisnessException {


        //Update Service
//        JSONObject jsonObject = new JSONObject();
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.ENTERED_PATIENTAPI_UPDATE) + " " + userId + " "
                +
                email + " " + password + " " + username + " " + age + " " + area + " " + city + " " + state);
        CustomResponse<String> customResponse = new CustomResponse<>();
        String message = LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.SUCCESSFULLY_UPDATED_PATIENT);


        patientDelegate.updatePatientDelegate(userId, email, password, username, age, area, city, state);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.PATIENT_UPDATE_IN_PATIENTAPI));
        return customResponse;
    }

    /**
     * Delete patient custom response.
     *
     * @param userId the user id
     * @return the custom response
     * @throws BuisnessException the buisness exception
     */
    @PUT
    @Path("deletepatient")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> deletePatient(@FormParam("userId") int userId) throws BuisnessException {

        //Delete Service
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.ENTERED_PATIENTAPI_DELETE) + " userId : " + userId);
        CustomResponse<String> customResponse = new CustomResponse<>();
        String message = LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.SUCCESSFULLY_DELETED_PATIENT);

        patientDelegate.deletePatientDelegate(userId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientApiConstants.PATIENT_DELETE_IN_PATIENTAPI));
        return customResponse;
    }

}
