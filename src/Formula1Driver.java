import java.io.Serializable;
import java.util.Objects;

public class Formula1Driver extends Driver implements Serializable, Comparable<Formula1Driver>{

    private int firstPlaces;
    private int secondPlaces;
    private int thirdPlaces;
    private int totalRaces;
    private int points;
    private int fourthPlaces;
    private int fifthPlaces;
    private int sixthPlaces;
    private int seventhPlaces;
    private int eighthPlaces;
    private int ninthPlaces;
    private int tenthPlace;
    private int aboveTenthPlaces;

    // default constructor
    public Formula1Driver(){
    }

    /**
     *
     * @param driverName driver name
     * @param driverLocation driver location
     * @param driverTeam driver team
     */
    public Formula1Driver(String driverName, String driverLocation, String driverTeam) {
        super(driverName, driverLocation, driverTeam);
    }

    /**
     *
     * @param driverName driver name
     * @param driverLocation location
     * @param driverTeam team
     * @param firstPlaces no of first places
     * @param secondPlaces no of second places
     * @param thirdPlaces no of third places
     * @param totalRaces total races
     * @param points total points
     * @param fourthPlaces fourth places
     * @param fifthPlaces fifth places
     * @param sixthPlaces sixth places
     * @param seventhPlaces seventh places
     * @param eighthPlaces eighth places
     * @param ninthPlaces ninth places
     * @param tenthPlace tenth places
     * @param aboveTenthPlaces above tenth
     */
    public Formula1Driver(String driverName, String driverLocation, String driverTeam, int firstPlaces,
                          int secondPlaces, int thirdPlaces, int totalRaces,
                          int points, int fourthPlaces, int fifthPlaces, int sixthPlaces, int seventhPlaces,
                          int eighthPlaces, int ninthPlaces, int tenthPlace, int aboveTenthPlaces) {
        super(driverName, driverLocation, driverTeam);
        this.firstPlaces = firstPlaces;
        this.secondPlaces = secondPlaces;
        this.thirdPlaces = thirdPlaces;
        this.fourthPlaces = fourthPlaces;
        this.fifthPlaces = fifthPlaces;
        this.sixthPlaces = sixthPlaces;
        this.seventhPlaces = seventhPlaces;
        this.eighthPlaces = eighthPlaces;
        this.ninthPlaces = ninthPlaces;
        this.tenthPlace = tenthPlace;
        this.aboveTenthPlaces = aboveTenthPlaces;
        this.totalRaces = totalRaces;
        this.points = points;
    }

    /**
     *
     * @return drivers no of first place wins
     */
    public int getFirstPlaces() {
        return firstPlaces;
    }

    public void setFirstPlaces(int firstPlaces) {
        this.firstPlaces = firstPlaces;
    }

    public int getSecondPlaces() {
        return secondPlaces;
    }

    public void setSecondPlaces(int secondPlaces) {
        this.secondPlaces = secondPlaces;
    }

    public int getThirdPlaces() {
        return thirdPlaces;
    }

    public void setThirdPlaces(int thirdPlaces) {
        this.thirdPlaces = thirdPlaces;
    }

    public int getFourthPlaces() {
        return fourthPlaces;
    }

    public void setFourthPlaces(int fourthPlaces) {
        this.fourthPlaces = fourthPlaces;
    }

    public int getFifthPlaces() {
        return fifthPlaces;
    }

    public void setFifthPlaces(int fifthPlaces) {
        this.fifthPlaces = fifthPlaces;
    }

    public int getSixthPlaces() {
        return sixthPlaces;
    }

    public void setSixthPlaces(int sixthPlaces) {
        this.sixthPlaces = sixthPlaces;
    }

    public int getSeventhPlaces() {
        return seventhPlaces;
    }

    public void setSeventhPlaces(int seventhPlaces) {
        this.seventhPlaces = seventhPlaces;
    }

    public int getEighthPlaces() {
        return eighthPlaces;
    }

    public void setEighthPlaces(int eighthPlaces) {
        this.eighthPlaces = eighthPlaces;
    }

    public int getNinthPlaces() {
        return ninthPlaces;
    }

    public void setNinthPlaces(int ninthPlaces) {
        this.ninthPlaces = ninthPlaces;
    }

    public int getTenthPlace() {
        return tenthPlace;
    }

    public void setTenthPlace(int tenthPlace) {
        this.tenthPlace = tenthPlace;
    }

    public int getAboveTenthPlaces() {
        return aboveTenthPlaces;
    }

    public void setAboveTenthPlaces(int aboveTenthPlaces) {
        this.aboveTenthPlaces = aboveTenthPlaces;
    }

    public int getTotalRaces() {
        return totalRaces;
    }

    public void setDriverTotalRaces(int dTotalRaces) {
        this.totalRaces = dTotalRaces;
    }

    public int getPoints() {
        setPoints(totalPointsCalculator());
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void incrementRaces() {
        this.totalRaces++;
    }

    public void incrementOtherPlaces(int place) {
        switch (place) {
            case 4:
                int newPoints1 = getFourthPlaces()+1;
                setFourthPlaces(newPoints1);
                break;
            case 5:
                int newPoints2 = getFifthPlaces()+1;
                setFifthPlaces(newPoints2);
                break;
            case 6:
                int newPoints3 = getSixthPlaces()+1;
                setSixthPlaces(newPoints3);
                break;
            case 7:
                int newPoints4 = getSeventhPlaces()+1;
                setSeventhPlaces(newPoints4);
                break;
            case 8:
                int newPoints5 = getEighthPlaces()+1;
                setEighthPlaces(newPoints5);
                break;
            case 9:
                int newPoints6 = getNinthPlaces()+1;
                setNinthPlaces(newPoints6);
                break;
            case 10:
                int newPoints7 = getTenthPlace()+1;
                setTenthPlace(newPoints7);
                break;
            default:
                int newPoints8 = getAboveTenthPlaces()+1;
                setAboveTenthPlaces(newPoints8);
                break;
        }
    }

    /**
     *
     * @return no. of points
     */
    public int fourthToTenthPointCalculator(){
        return getFourthPlaces()*12 + getFifthPlaces()*10 + getSixthPlaces()*8 + getSeventhPlaces()*6 +
                getEighthPlaces()*4 + getNinthPlaces()*2 + getTenthPlace();
    }

    /**
     *
     * @return total positions above first, second and third
     */
    public int totalOtherPositions(){
        return getFourthPlaces() + getFifthPlaces() + getSixthPlaces() + getSeventhPlaces() +
                getEighthPlaces() + getNinthPlaces() + getTenthPlace() + getAboveTenthPlaces();
    }

    /**
     *
     * @param achievedPlace increment place count
     */
    public void incrementPlaces(int achievedPlace) {
        if (achievedPlace > 0) {
            if (achievedPlace == 1) {
                this.firstPlaces++;
            } else if (achievedPlace == 2) {
                this.secondPlaces++;
            } else if (achievedPlace == 3) {
                this.thirdPlaces++;
            } else {
                incrementOtherPlaces(achievedPlace);
            }
        } else throw new IllegalArgumentException("Place should be a positive Integer!");
    }

    /**
     *
     * @return calculated total points
     */
    public int totalPointsCalculator(){
        int total1 = this.firstPlaces *25 + this.secondPlaces *18 + this.thirdPlaces *15;
        int total2 = fourthToTenthPointCalculator();
        return total1 + total2;
    }

    /**
     *
     * @param obj Formula1Driver Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Formula1Driver formula1Driver = (Formula1Driver) obj;

        return firstPlaces == formula1Driver.firstPlaces && secondPlaces == formula1Driver.secondPlaces &&
                thirdPlaces == formula1Driver.thirdPlaces && totalRaces == formula1Driver.totalRaces &&
                points == formula1Driver.points && fourthPlaces == formula1Driver.fourthPlaces && fifthPlaces == formula1Driver.fifthPlaces &&
                sixthPlaces == formula1Driver.sixthPlaces && seventhPlaces == formula1Driver.seventhPlaces && eighthPlaces == formula1Driver.eighthPlaces
                && ninthPlaces == formula1Driver.ninthPlaces && tenthPlace == formula1Driver.tenthPlace && aboveTenthPlaces == formula1Driver.aboveTenthPlaces;
    }

    /**
     *
     * @return hashcode value of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstPlaces, secondPlaces, thirdPlaces,
                totalRaces, points, fifthPlaces, fourthPlaces, sixthPlaces, seventhPlaces, eighthPlaces, ninthPlaces,
                tenthPlace, aboveTenthPlaces);
    }

    /**
     *
     * @return string of attributes of Formula1Driver object
     */
    @Override
    public String toString() {
        return "Formula1Driver {" +
                "name = " + this.getName() +
                " location = " + this.getLocation() +
                " team = " + this.getTeam() +
                '}';
    }

    /**
     *
     * @param formula1Driver object
     * @return integer
     */
    @Override
    public int compareTo(Formula1Driver formula1Driver) {
        int result = this.getPoints() - formula1Driver.getPoints();
        if (result == 0){
            return this.getFirstPlaces() - formula1Driver.getFirstPlaces();
        }
        return result;
    }
}

