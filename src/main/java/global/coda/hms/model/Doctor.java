package global.coda.hms.model;

/**
 * The type Doctor.
 */
public class Doctor extends  User {

    /**
     * Gets specialization.
     *
     * @return the specialization
     */
    public String getSpecialist() {
        return specialist;
    }

    /**
     * Sets specialization.
     *
     * @param specialist the specialization
     */
    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    /**
     * The Ima number.
     */
    int imaNumber;
    /**
     * The Specialization.
     */
    String specialist;

}
