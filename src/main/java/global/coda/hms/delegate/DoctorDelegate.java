package global.coda.hms.delegate;

import global.coda.hms.constant.applicationconstant.delegateconstants.DoctorDelegateConstants;
import global.coda.hms.constant.applicationconstant.delegateconstants.PatientDelegateConstants;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.DoctorHelper;
import global.coda.hms.helper.PatientHelper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * The type Doctor delegate.
 */
public class DoctorDelegate {
    /**
     * The Logger.
     */
    private Logger LOGGER = Logger.getLogger(DoctorDelegate.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    private DoctorHelper doctorHelper = new DoctorHelper();

    /**
     * Create doctor delegate.
     *
     * @param email      the email
     * @param password   the password
     * @param username   the username
     * @param specialist the specialist
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public void createDoctorDelegate(String email, String password, String username, String specialist) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_CREATE) + " "
                +
                email + " " + password + " " + username + " " + specialist);
        Doctor doctor = new Doctor();
        doctor.setUsername(username);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setSpecialist(specialist);
        Boolean success = false;
        if (doctorHelper.createDoctorHelper(doctor)) {
            success = true;
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.DOCTOR_CREATED_IN_DOCTARDELEGATE));
    }

    /**
     * Read doctor delegate doctor.
     *
     * @param userId the user id
     * @return the doctor
     * @throws BuisnessException the buisness exception
     */
    public Doctor readDoctorDelegate(int userId) throws BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_READ) + " userId : " + userId);

        Doctor doctor = new Doctor();
        doctor = doctorHelper.readDoctorHelper(userId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.DOCTOR_READ_IN_DOCTARDELEGATE) + "\n" + doctor);
        return doctor;
    }

    /**
     * Update doctor delegate.
     *
     * @param userId     the user id
     * @param email      the email
     * @param password   the password
     * @param username   the username
     * @param specialist the specialist
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public void updateDoctorDelegate(int userId, String email, String password, String username, String specialist) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_UPDATE) + " " + userId
                +
                email + " " + password + " " + username + " " + specialist);
        Doctor doctor = new Doctor();
        doctor.setUserId(userId);
        doctor.setUsername(username);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setSpecialist(specialist);
        Boolean success = false;
        if (doctorHelper.updateDoctorHelper(doctor)) {
            success = true;
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.DOCTOR_UPDATE_IN_DOCTARDELEGATE));
    }

    /**
     * Delete doctor delegate boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws BuisnessException the buisness exception
     */
    public Boolean deleteDoctorDelegate(int userId) throws BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_DELETE) + " userId : " + userId);

        doctorHelper.deleteDoctorHelper(userId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.DOCTOR_DELETE_IN_DOCTARDELEGATE));
        return true;
    }

    /**
     * Gets all patient under doctor delegate.
     *
     * @param doctorId the doctor id
     * @return the all patient under doctor delegate
     * @throws BuisnessException the buisness exception
     */
    public List<Patient> getAllPatientUnderDoctorDelegate(int doctorId) throws BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.ENTERED_PATIENTDELEGATE_DELETE) + " userId : " + doctorId);
        List<Patient> patientList = new ArrayList<>();
        PatientHelper patientHelper = new PatientHelper();
        patientList = patientHelper.getAllPatientUnderDoctorHelper(doctorId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.PATIENT_DELETE_IN_PATIENTDELEGATE));

        return patientList;
    }

    public List<Doctor> readAllDoctorsPatientsDelegate() throws BuisnessException, SystemException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.ENTERED_PATIENTDELEGATE_DELETE));

        Map< Integer,Doctor> doctorMap = new HashMap<Integer,Doctor>();
        doctorMap=doctorHelper.readAllDoctorsPatientsHelper();
        List<Doctor> doctorList=new ArrayList<>();
        for (Map.Entry<Integer,Doctor> doctor : doctorMap.entrySet()){

            doctorList.add(doctor.getValue());

        }

            LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.PATIENT_DELETE_IN_PATIENTDELEGATE));

        return doctorList;
    }
}
