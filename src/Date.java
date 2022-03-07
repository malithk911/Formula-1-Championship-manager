import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable, Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // default constructor
    public Date() {
    }

    /**
     *
     * @param year year of race
     * @param month month of race
     * @param day day of race
     */
    public Date(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     *
     * @param day day of race
     */
    public void setDay(int day) {
        if (day < 32) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("\nError. Invalid day.");
        }
    }

    /**
     *
     * @return month of race
     */
    public int getMonth() {
        return month;
    }

    /**
     *
     * @param month month of race
     */
    public void setMonth(int month) {
        if (month < 13) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("\nError. Invalid month.");
        }
    }

    /**
     *
     * @return year of race
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @param year year of race
     */
    public void setYear(int year) {
        if (year == 2021 || year == 2022) {
            this.year = year;
        }
        else {
            throw new IllegalArgumentException("\nError. Invalid year.");
        }
    }

    /**
     *
     * @return string of all attributes of object
     */
    @Override
    public String toString() {
        return "DateAndTime {" +
                "day = " + getDay() +
                ", month = " + getMonth() +
                ", year = " + getYear() +
                '}';
    }

    /**
     *
     * @param obj date object
     * @return integer
     */
    public int compareTo(Date obj) {
        int result = this.getYear() - obj.getYear();
        if (result == 0) {
            result = this.getMonth() - obj.getMonth();
            if (result == 0) {
                result = this.getDay() - obj.getDay();
                return result;
            }
            return result;
        }
        return result;
    }

    /**
     *
     * @param obj object to be compared
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Date date = (Date) obj;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    /**
     *
     * @return hashcode value of object
     */
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}

