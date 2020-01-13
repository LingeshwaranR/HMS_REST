package global.coda.hms.model;

/**
 * The type Patient.
 */
public class Patient extends User {


	/**
	 * Gets age.
	 *
	 * @return the age
	 */
	public int getAge() {
        return age;
    }

	/**
	 * Sets age.
	 *
	 * @param age the age
	 */
	public void setAge(int age) {
        this.age = age;
    }


	/**
	 * Gets area.
	 *
	 * @return the area
	 */
	public String getArea() {
        return area;
    }

	/**
	 * Sets area.
	 *
	 * @param area the area
	 */
	public void setArea(String area) {
        this.area = area;
    }

	/**
	 * Gets state.
	 *
	 * @return the state
	 */
	public String getState() {
        return state;
    }

	/**
	 * Sets state.
	 *
	 * @param state the state
	 */
	public void setState(String state) {
        this.state = state;
    }

	/**
	 * Gets city.
	 *
	 * @return the city
	 */
	public String getCity() {
        return city;
    }

	/**
	 * Sets city.
	 *
	 * @param city the city
	 */
	public void setCity(String city) {
        this.city = city;
    }

	/**
	 *
	 * @return
	 */
    @Override
    public String toString() {
        return age + "," + area + "," + city + "," + state;

    }


    private int age;
    private String area;
    private String state;
    private String city;
}
