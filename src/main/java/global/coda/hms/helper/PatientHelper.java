package global.coda.hms.helper;

import global.coda.hms.constant.applicationconstant.helperconstants.DoctorHelperConstants;
import global.coda.hms.constant.applicationconstant.helperconstants.PatientHelperConstants;
import global.coda.hms.dao.impl.DoctorDbDaoImpl;
import global.coda.hms.dao.impl.PatientDbDaoImpl;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Patient helper.
 */
public class PatientHelper {
    /**
     * The Logger.
     */
    private Logger LOGGER = Logger.getLogger(PatientHelper.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    /**
     * The Patient db dao.
     */
    private PatientDbDaoImpl patientDbDaoImpl = new PatientDbDaoImpl();

    /**
     * Create patient helper boolean.
     *
     * @param patient the patient
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public Boolean createPatientHelper(Patient patient) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.ENTERED_PATIENTHELPER_CREATE) + " " + patient);
        Boolean success = false;
        try {
            if (patientDbDaoImpl.create(patient)) {
                success = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            throw new BuisnessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.DOCTOR_CREATED_IN_DOCTARHELPER));
        return success;
    }

    /**
     * Read patient helper patient.
     *
     * @param userId the user id
     * @return the patient
     * @throws BuisnessException the buisness exception
     */
    public Patient readPatientHelper(int userId) throws BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.ENTERED_PATIENTHELPER_READ) + " userId : " + userId);
        Patient patient = new Patient();
        try {
            patient = patientDbDaoImpl.read(userId);
        } catch (SQLException e) {
            throw new BuisnessException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.PATIENT_READ_IN_PATIENTHELPER) + "\n" + patient);
        return patient;
    }

    /**
     * Update patient helper boolean.
     *
     * @param patient the patient
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public Boolean updatePatientHelper(Patient patient) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.ENTERED_PATIENTHELPER_UPDATE) + " " + patient);
        Boolean success = false;
        try {
            patientDbDaoImpl.read(patient.getUserId());
            if (patientDbDaoImpl.update(patient)) {
                success = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            throw new BuisnessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.PATIENT_UPDATE_IN_PATIENTHELPER));

        return success;
    }

    /**
     * Delete patient helper.
     *
     * @param userId the user id
     * @throws BuisnessException the buisness exception
     */
    public void deletePatientHelper(int userId) throws BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.ENTERED_PATIENTHELPER_DELETE) + " userId : " + userId);
        try {
            patientDbDaoImpl.read(userId);
            patientDbDaoImpl.delete(userId);
        } catch (SQLException e) {
            throw new BuisnessException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.PATIENT_DELETE_IN_PATIENTHELPER));
    }

    /**
     * Gets all patient under doctor helper.
     *
     * @param doctorId the doctor id
     * @return the all patient under doctor helper
     * @throws BuisnessException the buisness exception
     */
    public List<Patient> getAllPatientUnderDoctorHelper(int doctorId) throws BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.ENTERED_PATIENTHELPER_DELETE) + " doctorId : " + doctorId);
        List<Patient> patientList = new ArrayList<>();

        try {
            DoctorDbDaoImpl doctorDbDaoImpl = new DoctorDbDaoImpl();
            doctorDbDaoImpl.read(doctorId);
            patientList = patientDbDaoImpl.getAllPatientIDMappedUnderADoctor(doctorId);
        } catch (SQLException e) {
            throw new BuisnessException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.PATIENT_DELETE_IN_PATIENTHELPER));
        return patientList;
    }
}
