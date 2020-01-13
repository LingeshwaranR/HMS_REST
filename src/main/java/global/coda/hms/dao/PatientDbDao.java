package global.coda.hms.dao;

import global.coda.hms.model.Patient;
import global.coda.hms.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface Patient db dao.
 */
public interface PatientDbDao {
    /**
     * Insert boolean.
     *
     * @param patient the patient
     * @return the boolean
     * @throws SQLException the sql exception
     */
    Boolean create(Patient patient) throws SQLException;

    /**
     * Read user.
     *
     * @param userId the user id
     * @return the user
     * @throws SQLException the sql exception
     */
    User read(int userId) throws SQLException;

    /**
     * Read all list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
    List<Patient> readAll() throws SQLException;

    /**
     * Update boolean.
     *
     * @param patient the patient
     * @return the boolean
     * @throws SQLException the sql exception
     */
    Boolean update(Patient patient) throws SQLException;

    /**
     * Delete boolean.
     *
     * @param userId the user id
     * @return the boolean
     * @throws SQLException the sql exception
     */
    Boolean delete(int userId) throws SQLException;

    /**
     * Read all with masked details list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
    List<Patient> readAllWithMaskedDetails() throws SQLException;

    /**
     * Gets all patient id mapped under a doctor.
     *
     * @param doctorId the doctor id
     * @return the all patient id mapped under a doctor
     * @throws SQLException the sql exception
     */
    List<Patient> getAllPatientIDMappedUnderADoctor(int doctorId) throws SQLException;


}
