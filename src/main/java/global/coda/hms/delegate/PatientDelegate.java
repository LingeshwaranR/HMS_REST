package global.coda.hms.delegate;

import global.coda.hms.constant.applicationconstant.delegateconstants.PatientDelegateConstants;
import global.coda.hms.exception.BuisnessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.helper.PatientHelper;
import global.coda.hms.model.Patient;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public class PatientDelegate {
    Logger LOGGER = Logger.getLogger(PatientDelegate.class);

    private static final ResourceBundle LOCAL_MESSAGES_BUNDLE = ResourceBundle.getBundle("messages",
            Locale.getDefault());
    PatientHelper patientHelper= new PatientHelper();
    public void createPatientDelegate(String email, String password, String username, int age,String area,String city,String state ) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.ENTERED_PATIENTDELEGATE_CREATE) + " " +
                email + " " + password + " " + username + " " + age + " " + area + " " +city + " "+state);
        Patient patient = new Patient();
        patient.setUsername(username);
        patient.setEmail(email);
        patient.setPassword(password);
        patient.setAge(age);
        patient.setArea(area);
        patient.setCity(city);
        patient.setState(state);
        Boolean success = false;
        if (patientHelper.createPatientHelper(patient)) {
            success = true;
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.PATIENT_CREATED_IN_PATIENTDELEGATE));
    }
    public Patient readPatientDelegate(int userId) throws  BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.ENTERED_PATIENTDELEGATE_READ) + " userId : " +userId);
        Patient patient=new Patient();
        patient=patientHelper.readPatientHelper(userId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.PATIENT_READ_IN_PATIENTDELEGATE) + "\n" + patient);
        return patient;
    }
    public void updatePatientDelegate(int userId,String email, String password, String username, int age,String area,String city,String state ) throws SystemException, BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.ENTERED_PATIENTDELEGATE_UPDATE)+ " " +userId + " "+
                email + " " + password + " " + username + " " + age + " " + area + " " +city + " "+state);
        Patient patient = new Patient();
        patient.setUserId(userId);
        patient.setUsername(username);
        patient.setEmail(email);
        patient.setPassword(password);
        patient.setAge(age);
        patient.setArea(area);
        patient.setCity(city);
        patient.setState(state);
        Boolean success = false;
        if (patientHelper.updatePatientHelper(patient)) {
            success = true;
        }
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.PATIENT_UPDATE_IN_PATIENTDELEGATE));
    }
    public void deletePatientDelegate(int userId) throws  BuisnessException {
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.ENTERED_PATIENTDELEGATE_DELETE) + " userId : " +userId);

        patientHelper.deletePatientHelper(userId);
        LOGGER.info(LOCAL_MESSAGES_BUNDLE.getString(PatientDelegateConstants.PATIENT_DELETE_IN_PATIENTDELEGATE));
    }
}
