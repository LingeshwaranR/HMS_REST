package global.coda.hms.dao;

import global.coda.hms.model.Doctor;

import java.sql.SQLException;
import java.util.List;

/**
 * The interface Doctor db dao.
 */
public interface DoctorDbDao {
    /**
     * Insert boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     * @throws SQLException the sql exception
     */
    Boolean create(Doctor doctor) throws SQLException;

    /**
     * Read doctor.
     *
     * @param userId the id
     * @return the doctor
     * @throws SQLException the sql exception
     */
    Doctor read(int userId) throws SQLException;

    /**
     * Read all list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
     List<Doctor> readAll() throws SQLException;

    /**
     * Read all with masked details list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
     List<Doctor> readAllWithMaskedDetails() throws SQLException;

    /**
     * Update boolean.
     *
     * @param doctor the doctor
     * @return the boolean
     * @throws SQLException the sql exception
     */
     Boolean update(Doctor doctor) throws SQLException;

    /**
     * Delete boolean.
     *
     * @param userId the doctor
     * @return the boolean
     * @throws SQLException the sql exception
     */
     Boolean delete(int userId) throws SQLException;

     List<Integer > readAllDoctorId() throws SQLException;
}
