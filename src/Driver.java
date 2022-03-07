import java.io.Serializable;
import java.util.Objects;

public abstract class Driver implements Serializable {
    private String name;
    private String location;
    private String team;

    // default constructor
    public Driver(){
    }

    /**
     *
     * @param name drivers name
     * @param location drivers location
     * @param team drivers team
     */
    public Driver(String name, String location, String team) {
        this.name = name;
        this.location = location;
        this.team = team;
    }

    /**
     *
     * @return name of driver
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name name of driver
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return location of driver
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location location of driver
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return drivers team
     */
    public String getTeam() {
        return this.team;
    }

    /**
     *
     * @param team drivers team
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     *
     * @return string of object with name, location and team
     */
    @Override
    public String toString() {
        return "Driver {" +
                "name = " + getName() +
                ", location = " + getLocation() +
                ", team = " + getTeam() +
                '}';
    }

    /**
     *
     * @param obj driver object
     * @return boolean true if equals, else false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Driver driver = (Driver) obj;
        return Objects.equals(name, driver.name) &&
                Objects.equals(location, driver.location) &&
                Objects.equals(team, driver.team);
    }

    /**
     *
     * @return hashcode value of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, location, team);
    }

}

