package global.coda.hms.helper;

import global.coda.hms.constant.applicationconstant.helperconstants.DoctorHelperConstants;
import global.coda.hms.constant.applicationconstant.helperconstants.PatientHelperConstants;
import global.coda.hms.dao.impl.PatientDbDaoImpl;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Locale;
import java.util.ResourceBundle;

public class PatientHelper {
    Logger LOGGER = Logger.getLogger(PatientHelper.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    PatientDbDaoImpl patientDbDaoImpl = new PatientDbDaoImpl();

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

    public void deletePatientHelper(int userId) throws BuisnessException{
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.ENTERED_PATIENTHELPER_DELETE) + " userId : " + userId );
        try {
            patientDbDaoImpl.read(userId);
            patientDbDaoImpl.delete(userId);
        }
        catch (SQLException e) {
            throw new BuisnessException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientHelperConstants.PATIENT_DELETE_IN_PATIENTHELPER));
    }
}