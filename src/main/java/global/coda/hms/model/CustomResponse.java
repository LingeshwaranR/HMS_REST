package global.coda.hms.model;

/**
 * The type Custom response.
 *
 * @param <T> the type parameter
 */
public class CustomResponse<T> {
    /**
     * Gets success.
     *
     * @return the success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Sets success.
     *
     * @param success the success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets object.
     *
     * @return the object
     */
    public T getObject() {
        return object;
    }

    /**
     * Sets object.
     *
     * @param object the object
     */
    public void setObject(T object) {
        this.object = object;
    }

    /**
     * The Success.
     */
    Boolean success;
    /**
     * The Status.
     */
    int status;
    /**
     * The Object.
     */
    T object;


}
