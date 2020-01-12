package global.coda.hms.exception;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * The type Buisness exception.
 */
public class BuisnessException extends Exception {
    /**
     * Instantiates a new Buisness exception.
     * @param e
     */
    public BuisnessException(Exception e) {
        super(e);

    }
}
