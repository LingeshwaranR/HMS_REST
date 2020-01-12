package global.coda.hms.api;

import global.coda.hms.constant.applicationconstant.apiconstants.DoctorApiContants;
import global.coda.hms.constant.applicationconstant.delegateconstants.DoctorDelegateConstants;
import global.coda.hms.delegate.DoctorDelegate;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.exceptionmapper.SystemExceptionMapper;
import global.coda.hms.model.CustomResponse;
import global.coda.hms.model.Doctor;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
 * The type Doctor api.
 */
@Path("/api/doctor")
public class DoctorApi {
    /**
     * The Logger.
     */
    Logger LOGGER = Logger.getLogger(DoctorApi.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());

    private DoctorDelegate doctorDelegate = new DoctorDelegate();

    public DoctorApi() {
        BasicConfigurator.configure();
    }

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
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.ENTERED_DOCTORAPI_CREATE)+" "+
                email+" "+password+" "+username+" "+specialist);
        CustomResponse<String> customResponse= new CustomResponse<>();
        String message=LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.SUCCESSFULLY_CREATED);


        doctorDelegate.createDoctorDelegate(email,password,username,specialist);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.DOCTOR_CREATED_IN_DOCTARAPI));
        return customResponse;
    }

    @POST
    @Path("readdoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<Doctor> readPatient(@FormParam("userId") int userId) throws  BuisnessException {

        //Read Service
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.ENTERED_DOCTORAPI_READ)+ " userId : " + userId);
        CustomResponse<Doctor> customResponse= new CustomResponse<>();
        Doctor doctor= new Doctor();
        doctor=doctorDelegate.readDoctorDelegate(userId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(doctor);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.DOCTOR_READ_IN_DOCTARAPI));
        return customResponse;
    }
    @PUT
    @Path("updatedoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> updatePatient(@FormParam("userId")int userId,
                                                @FormParam("email") String email,
                                                @FormParam("password") String password,
                                                @FormParam("username") String username,
                                                @FormParam("specialist") String specialist

    ) throws SystemException, BuisnessException {


        //Update Service
//        JSONObject jsonObject = new JSONObject();
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.ENTERED_DOCTORAPI_UPDATE)+" "+userId+
                email+" "+password+" "+username+" "+specialist);
        CustomResponse<String> customResponse= new CustomResponse<>();
        String message=LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.SUCCESSFULLY_UPDATED);


        doctorDelegate.updateDoctorDelegate(userId,email,password,username,specialist);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.DOCTOR_UPDATE_IN_DOCTARAPI));
        return customResponse;
    }
    @PUT
    @Path("deletedoctor")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public CustomResponse<String> deletePatient(@FormParam("userId") int userId) throws  BuisnessException {

        //Delete Service
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.ENTERED_DOCTORAPI_DELETE)+ " userId : " + userId);
        CustomResponse<String> customResponse= new CustomResponse<>();
        String message=LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.SUCCESSFULLY_DELETED);

        doctorDelegate.deleteDoctorDelegate(userId);
        customResponse.setSuccess(true);
        customResponse.setStatus(Response.Status.CREATED.getStatusCode());
        customResponse.setObject(message);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorApiContants.DOCTOR_DELETE_IN_DOCTARAPI));
        return customResponse;
    }


}

