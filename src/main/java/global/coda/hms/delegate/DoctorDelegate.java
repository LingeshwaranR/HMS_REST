package global.coda.hms.delegate;

import global.coda.hms.constant.applicationconstant.delegateconstants.DoctorDelegateConstants;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.DoctorHelper;
import global.coda.hms.model.Doctor;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class DoctorDelegate {
    Logger LOGGER = Logger.getLogger(DoctorDelegate.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    private DoctorHelper doctorHelper = new DoctorHelper();

    public void createDoctorDelegate(String email, String password, String username, String specialist) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_CREATE) + " " +
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

    public Doctor readDoctorDelegate(int userId) throws  BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_READ) + " userId : " +userId);

                Doctor doctor = new Doctor();
        doctor=doctorHelper.readDoctorHelper(userId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.DOCTOR_READ_IN_DOCTARDELEGATE) + "\n" + doctor);
        return doctor;
    }
    public void updateDoctorDelegate(int userId,String email, String password, String username, String specialist) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_UPDATE) + " " +userId+
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
    public Boolean deleteDoctorDelegate(int userId) throws  BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.ENTERED_DOCTORDELEGATE_DELETE) + " userId : " +userId);

        doctorHelper.deleteDoctorHelper(userId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(DoctorDelegateConstants.DOCTOR_DELETE_IN_DOCTARDELEGATE));
        return true;
    }
}
