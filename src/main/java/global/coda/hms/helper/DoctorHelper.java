package global.coda.hms.helper;

import global.coda.hms.constant.applicationconstant.helperconstants.DoctorHelperConstants;
import global.coda.hms.dao.impl.DoctorDbDaoImpl;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Doctor helper.
 */
public class DoctorHelper {
    Logger LOGGER = Logger.getLogger(DoctorHelper.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());

    private DoctorDbDaoImpl doctorDbDaoImpl = new DoctorDbDaoImpl();

    /**
     * Insert doctor helper boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     */
    public Boolean createDoctorHelper(Doctor doctor) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.ENTERED_DOCTORHELPER_CREATE)+" "+doctor);
        Boolean success = false;
        try {
            if (doctorDbDaoImpl.create(doctor)) {
                success = true;
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            throw new BuisnessException(e);
        }
        catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.DOCTOR_CREATED_IN_DOCTARHELPER));
        return success;
    }
    public Doctor readDoctorHelper(int userId) throws BuisnessException{
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.ENTERED_DOCTORHELPER_READ) + " userId : " + userId );
        Doctor doctor= new Doctor();
        try {
          doctor=  doctorDbDaoImpl.read(userId);
        }
        catch (SQLException e) {
            throw new BuisnessException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.DOCTOR_READ_IN_DOCTARHELPER) + "\n" + doctor);
        return doctor;
    }
    public Boolean updateDoctorHelper(Doctor doctor) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.ENTERED_DOCTORHELPER_UPDATE)+" "+doctor);
        Boolean success = false;
        try {
            if (doctorDbDaoImpl.update(doctor)) {
                success = true;
            }
        }
        catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            throw new BuisnessException(e);
        }
        catch (SQLException e) {
            throw new SystemException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.DOCTOR_UPDATE_IN_DOCTARHELPER));
        return success;
    }
    public Boolean deleteDoctorHelper(int userId) throws BuisnessException{
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.ENTERED_DOCTORHELPER_DELETE) + " userId : " + userId );
        try {
            doctorDbDaoImpl.read(userId);
            doctorDbDaoImpl.delete(userId);
        }
        catch (SQLException e) {
            throw new BuisnessException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.DOCTOR_DELETE_IN_DOCTARHELPER));
        return true;
    }
}
