package global.coda.hms.dao;

import global.coda.hms.model.User;

import java.sql.SQLException;

/**
 * The interface User db dao.
 */
public interface UserDbDao  {
    /**
     * Gets user.
     *
     * @param email the email
     * @return the user
     * @throws SQLException the sql exception
     */
    User getUser(String email) throws SQLException;
}
