package global.coda.hms.helper;

import global.coda.hms.constant.applicationconstant.helperconstants.DoctorHelperConstants;
import global.coda.hms.dao.impl.DoctorDbDao;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * The type Doctor helper.
 */
public class DoctorHelper {
    /**
     * The Logger.
     */
    private static Logger LOGGER = LogManager.getLogger(DoctorHelper.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());


    /**
     * Insert doctor helper boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public static Boolean createDoctorHelper(Doctor doctor) throws SystemException, BuisnessException {
        LOGGER.traceEntry(doctor.toString());
        Boolean success = null;
        try {
            if (DoctorDbDao.create(doctor)) {
                success = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            throw new BuisnessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.traceExit();
        return success;
    }

    /**
     * Read doctor helper doctor.
     *
     * @param userId the user id
     * @return the doctor
     * @throws Exception the exception
     */
    public static Doctor readDoctorHelper(int userId) throws BuisnessException,SystemException {
        LOGGER.entry(userId);
        Doctor doctor;
        try {
            doctor = DoctorDbDao.read(userId);
            if (doctor.getUsername() == null) {
                //FIX
                throw new BuisnessException("User Id Not Found in DB");
            }
        } catch (SQLException e) {

            throw new BuisnessException(e);
        }
        catch (Exception e){
            LOGGER.error(e);

            throw new SystemException(e);
        }
        LOGGER.traceExit(doctor);
        return doctor;
    }


    /**
     * Update doctor helper boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public static Boolean updateDoctorHelper(Doctor doctor) throws SystemException, BuisnessException {
        LOGGER.traceEntry(doctor.toString());
        Boolean success = false;
        try {
            if (DoctorDbDao.update(doctor)) {
                success = true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate entry
            throw new BuisnessException(e);
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.traceEntry(String.valueOf(success));
        return success;
    }

    /**
     * Delete doctor helper boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws Exception the exception
     */
    public static Boolean deleteDoctorHelper(int userId) throws BuisnessException, SystemException {
        LOGGER.traceEntry(String.valueOf(userId));
        try {
            DoctorDbDao.read(userId);
            DoctorDbDao.delete(userId);
        } catch (SQLException e) {
            throw new BuisnessException(e);
        } catch (Exception e) {
                throw new SystemException(e);
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorHelperConstants.DOCTOR_DELETE_IN_DOCTARHELPER));
        return true;
    }

    /**
     * Read all doctor id helper list.
     *
     * @return the list
     * @throws SystemException   the system exception
     * @throws BuisnessException the buisness exception
     */
    public static List<Integer> readAllDoctorIdHelper() throws SystemException, BuisnessException {
        LOGGER.traceEntry();
        List<Integer> doctorIdList = new ArrayList<>();
        try {
            doctorIdList = DoctorDbDao.readAllDoctorId();
        } catch (SQLException e) {
            throw new SystemException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.traceExit(doctorIdList);
        return doctorIdList;
    }

    /**
     * Read all doctors patients helper map.
     *
     * @return the map
     * @throws Exception the exception
     */
    public static Map<Integer, Doctor> readAllDoctorsPatientsHelper() throws BuisnessException,SystemException {
        LOGGER.traceEntry();
        Map<Integer, Doctor> doctorMap = new HashMap<Integer, Doctor>();

        try {
            doctorMap = DoctorDbDao.readAllDoctorsPatients();
        } catch (Exception e) {
            throw new SystemException(e);
        }
        LOGGER.traceExit(doctorMap);
        return doctorMap;
    }
}
