package global.coda.hms.exception;


import java.sql.SQLException;

/**
 * The type Buisness exception.
 */
public class BuisnessException extends Exception {
    /**
     * Instantiates a new Buisness exception.
     */
    public BuisnessException() {
    }

    /**
     * Instantiates a new Buisness exception.
     *
     * @param message the message
     */
    public BuisnessException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Buisness exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BuisnessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Buisness exception.
     *
     * @param cause the cause
     */
    public BuisnessException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Buisness exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public BuisnessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new Buisness exception.
     *
     * @param e the e
     */
    public BuisnessException(SQLException e) {
        super(e);

    }
}
