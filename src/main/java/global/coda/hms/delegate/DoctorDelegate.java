package global.coda.hms.delegate;

import global.coda.hms.constant.applicationconstant.delegateconstants.DoctorDelegateConstants;
import global.coda.hms.constant.applicationconstant.delegateconstants.PatientDelegateConstants;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.DoctorHelper;
import global.coda.hms.helper.PatientHelper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static Logger LOGGER = LogManager.getLogger(DoctorDelegate.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());

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
    public static void createDoctorDelegate(String email, String password, String username, String specialist) throws SystemException, BuisnessException {
        LOGGER.traceEntry(email + " " + password + " " + username + " " + specialist);
        Doctor doctor = new Doctor();
        doctor.setUsername(username);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setSpecialist(specialist);
        Boolean success = false;
        if (DoctorHelper.createDoctorHelper(doctor)) {
            success = true;
        }
        LOGGER.traceExit();
    }

    /**
     * Read doctor delegate doctor.
     *
     * @param userId the user id
     * @return the doctor
     * @throws BuisnessException the buisness exception
     */
    public static Doctor readDoctorDelegate(int userId) throws BuisnessException, SystemException {
        LOGGER.traceEntry(String.valueOf(userId));

        Doctor doctor;
        doctor = DoctorHelper.readDoctorHelper(userId);
        LOGGER.traceExit( doctor);
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
    public static void updateDoctorDelegate(int userId, String email, String password, String username, String specialist) throws SystemException, BuisnessException {
        LOGGER.entry(userId + email + " " + password + " " + username + " " + specialist);
        Doctor doctor = new Doctor();
        doctor.setUserId(userId);
        doctor.setUsername(username);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setSpecialist(specialist);
        Boolean success = false;
        if (DoctorHelper.updateDoctorHelper(doctor)) {
            success = true;
        }
        LOGGER.traceExit();
    }

    /**
     * Delete doctor delegate boolean.
     *
     * @param userId the user id
     * @throws BuisnessException the buisness exception
     */
    public static void deleteDoctorDelegate(int userId) throws BuisnessException, SystemException {
        LOGGER.traceEntry(String.valueOf(userId));

        DoctorHelper.deleteDoctorHelper(userId);
        LOGGER.traceExit();
    }

    /**
     * Gets all patient under doctor delegate.
     *
     * @param doctorId the doctor id
     * @return the all patient under doctor delegate
     * @throws BuisnessException the buisness exception
     */
    public static List<Patient> getAllPatientUnderDoctorDelegate(int doctorId) throws BuisnessException, SystemException {
        LOGGER.entry( " userId : " + doctorId);
        List<Patient> patientList = new ArrayList<>();
        //FIX : USE STATIC INSTEAD OF OBJECTS
        PatientHelper patientHelper = new PatientHelper();
        patientList = patientHelper.getAllPatientUnderDoctorHelper(doctorId);
        LOGGER.traceExit(patientList);

        return patientList;
    }

    public static List<Doctor> readAllDoctorsPatientsDelegate() throws BuisnessException, SystemException {
        LOGGER.traceEntry();

        Map< Integer,Doctor> doctorMap = new HashMap<Integer,Doctor>();
        doctorMap=DoctorHelper.readAllDoctorsPatientsHelper();
        List<Doctor> doctorList=new ArrayList<>();
        for (Map.Entry<Integer,Doctor> doctor : doctorMap.entrySet()){

            doctorList.add(doctor.getValue());

        }

            LOGGER.traceExit(doctorList);

        return doctorList;
    }
}
