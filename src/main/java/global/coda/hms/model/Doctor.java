package global.coda.hms.model;

import java.util.List;

/**
 * The type Doctor.
 */
public class Doctor extends User {

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
     * The Specialization.
     */
    String specialist;

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    List<Patient> patientList;

}
