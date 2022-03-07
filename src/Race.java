import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Race implements Serializable, Comparable<Race> {

    private Date dateOfRace;
    List<Formula1Driver> driversOfRace = new ArrayList<>();
    List<Integer> rankingsOfRace = new ArrayList<>();

    // default constructor
    public Race() {
    }

    /**
     *
     * @param dateOfRace race date
     * @param driversOfRace drivers
     * @param rankingsOfRace rankings
     */
    public Race(Date dateOfRace, List<Formula1Driver> driversOfRace, List<Integer> rankingsOfRace) {
        this.setDateOfRace(dateOfRace);
        this.setDriversOfRace(driversOfRace);
        this.setRankingsOfRace(rankingsOfRace);
    }

    /**
     *
     * @return date
     */
    public Date getDateOfRace() {
        return dateOfRace;
    }

    /**
     *
     * @param dateOfRace set date
     */
    public void setDateOfRace(Date dateOfRace) {
        this.dateOfRace = dateOfRace;
    }

    /**
     *
     * @return drivers list
     */
    public List<Formula1Driver> getDriversOfRace() {
        return driversOfRace;
    }

    /**
     *
     * @param driversOfRace set drivers list
     */
    public void setDriversOfRace(List<Formula1Driver> driversOfRace) {
        this.driversOfRace = driversOfRace;
    }

    /**
     *
     * @return rankings
     */
    public List<Integer> getRankingsOfRace() {
        return rankingsOfRace;
    }

    /**
     *
     * @param rankingsOfRace set rankings
     */
    public void setRankingsOfRace(List<Integer> rankingsOfRace) {
        this.rankingsOfRace = rankingsOfRace;
    }

    /**
     *
     * @param race Race object
     * @return int 0 if o1 == o2
     *             1 if o1 > o2
     *             -1 if o1 < o2
     */
    @Override
    public int compareTo(Race race) {
        return getDateOfRace().compareTo(race.getDateOfRace());
    }
}

