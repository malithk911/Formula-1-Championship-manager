import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Formula1ChampionshipManager implements Serializable, ChampionshipManager {
    public static String file = "championshipDetails.ser";

    /**
     *
     * @param name name of driver
     * @param location location of driver
     * @param team team of driver
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void add(String name, String location, String team) throws IOException, ClassNotFoundException {

        Formula1Driver newF1Driver = new Formula1Driver(name,location,team);

        boolean exists = false;
        for(Formula1Driver driver : DRIVER_LIST){
            if(driver.getTeam().equalsIgnoreCase(newF1Driver.getTeam())){
                System.out.println("\n⚠ Error. The team of driver already exists!");
                return;
            }
        }

        if(!exists){
            DRIVER_LIST.add(newF1Driver);
            DRIVER_LIST.sort(Collections.reverseOrder());
            System.out.println("\n⬤ Driver added successfully!");
            System.out.println(DRIVER_LIST);
        }
    }

    /**
     * show all drivers
     */
    @Override
    public void show() {
        int i = 1;
        for (Formula1Driver driver : DRIVER_LIST){
            System.out.println("\nCurrent F1 Drivers : Number " + i + "\nRepresenting F1 Team : " +
                    driver.getTeam() + "\nF1 Driver Name : " + driver + "\n\n");
            i++;
        }
    }

    /**
     *
     * @param name name of driver
     * @param team team of driver
     */
    @Override
    public void delete(String name, String team) {
        boolean found = false;
        for (Formula1Driver driver: DRIVER_LIST)  {
            if (driver.getName().equalsIgnoreCase(name) && driver.getTeam().equalsIgnoreCase(team)) {
                DRIVER_LIST.remove(driver);
                found = true;
                System.out.println("\n⬤ Driver removed successfully!");
                break;
            }
        }

        if(!found){
            System.out.println("\n⚠ Error. Driver doesn't exist.");
        }
    }

    /**
     *
     * @param name name of driver
     * @param currentTeam current team of driver
     * @param newTeam new team of driver
     */
    @Override
    public void changeTeam(String name, String currentTeam, String newTeam) {
        boolean found = false;
        for (Formula1Driver driver: DRIVER_LIST) {
            if (driver.getName().equalsIgnoreCase(name) && driver.getTeam().equalsIgnoreCase(currentTeam)) {
                driver.setTeam(newTeam);
                found = true;
                System.out.println("\n⬤ Team of driver " + driver.getName() + " changed successfully!");
                break;
            }
        }
        if(!found){
            System.out.println("\n⚠ Error. Driver doesn't exist.");
        }
    }

    /**
     *
     * @param name name of driver
     * @param team team of driver
     * @return stats of driver
     */
    @Override
    public String displayStats(String name, String team) {
        int i = 1;
        for (Formula1Driver driver : DRIVER_LIST) {
            if (driver.getName().equalsIgnoreCase(name) && driver.getTeam().equalsIgnoreCase(team)) {
                return "\nDriver Profile =======>     " + driver.getName().toUpperCase() +
                        "\n—————————————————————————————————————————\n" +
                        "Present Season Rank          :  " + DRIVER_LIST.indexOf(driver) + 1 + "\n" +
                        "Representing F1 Team         :  " + driver.getTeam() + "\n" +
                        "Location of driver           :  " + driver.getLocation() + "\n" +
                        "Solo career race total       :  " + driver.getTotalRaces() + "\n" +
                        "1st Podium Placements        :  " + driver.getFirstPlaces() + "\n" +
                        "2nd Podium Placements        :  " + driver.getSecondPlaces() + "\n" +
                        "3rd Podium Placements        :  " + driver.getThirdPlaces() + "\n" +
                        "—————————————————————————————————————————\n" +
                        "Cumulative season points      :  " + driver.getPoints() + "\n"+
                        "—————————————————————————————————————————\n";
            }
        }
        return "\n⚠ Error. Driver not found.";
    }

    /**
     *
     * @return table in string format
     */
    @Override
    public String showFormula1Table() {

        if(DRIVER_LIST.isEmpty()){
            return "\n⚠ Error. No drivers in the championship.";
        }

        StringBuilder output = new StringBuilder();
        System.out.println();
        System.out.println("\n\t\t\t\t———————————————————————————————————————————————————————————————————— CHAMPIONSHIP TABLE " +
                "————————————————————————————————————————————————————————————————————\n");

        System.out.println("\n|--------------------------------------------------------------------------" +
        "---------------------------------------------------------------------------------------------" +
                "------------------------|");

        String tableHeader = String.format("%-20s %-20s %-20s %-15s %-15s %-20s %-20s %-20s %-20s %-5s",
                "|Rank", "|Name", "|Location", "|Team", "|Races", "|1st Places", "|2nd Places", "|3rd Places",
                "|4th Places", "|Points      |\n|--------------------------------------------------------------------------" +
                        "---------------------------------------------------------------------------------------------" +
                        "------------------------|");
        output.append(tableHeader).append("\n");
        DRIVER_LIST.sort(Collections.reverseOrder());

        int i = 1;
        for (Formula1Driver driver : DRIVER_LIST) {
            String result = String.format("|%-20s|%-20s|%-20s|%-15s|%-15s|%-20s|%-20s|%-20s|%-20s|%-5s",
                    i, driver.getName(), driver.getLocation(), driver.getTeam(),
                    driver.getTotalRaces(), driver.getFirstPlaces(), driver.getSecondPlaces(),
                    driver.getThirdPlaces(),driver.totalOtherPositions(),driver.getPoints());
            output.append(result).append("\t\t|\n");
            i++;
        }

        output.append("|------------------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------------------------------------------|\n\n\n");

        return output.toString();
    }

    /**
     *
     * @param race race object
     */
    @Override
    public void addRace() {
        System.out.println("\n⬤ Enter date of match (DD.MM.YYYY) : ");
        Scanner userInput = new Scanner(System.in);
        Date dateOfRace = new Date(); // create a date object
        String userInputDate = userInput.next();

        // split date string into day, month and year
        String [] arr = userInputDate.split("\\.", 3);

        // convert split values to integer
        if((Integer.parseInt(arr[0]) > 0 && Integer.parseInt(arr[0]) <= 31) &&
                (Integer.parseInt(arr[1]) > 0 && Integer.parseInt(arr[1]) <= 12) &&
                (Integer.parseInt(arr[2]) == 2021 || Integer.parseInt(arr[2]) == 2022)){
            dateOfRace.setDay(Integer.parseInt(arr[0]));
            dateOfRace.setMonth(Integer.parseInt(arr[1]));
            dateOfRace.setYear(Integer.parseInt(arr[2]));
        } else {
            System.out.println("\n⚠ Error. Invalid date. Enter a valid date.");
            return;
        }

        List<Formula1Driver> tempList1 = new ArrayList<>();
        List<Integer> tempList2 = new ArrayList<>();

        int i = 0;
        for (Formula1Driver raceDriver : DRIVER_LIST){
            if(i == 11){
                System.out.println("\n⬤ Maximum possible drivers added to race.");
                return;
            }

            System.out.println("\n——————————————————————————————————————————————————————————————————————————————");
            System.out.println("Current F1 Drivers : Number " + i + "\nRepresenting F1 Team : " +
                    raceDriver.getTeam() + "\nF1 Driver Name : " + raceDriver.getName());
            System.out.println("——————————————————————————————————————————————————————————————————————————————");
            System.out.println("Add driver to race? (y/n): ");
            String choice = userInput.next();

            if(choice.equalsIgnoreCase("y")){
                System.out.println("Position in race? ");
                int position = userInput.nextInt();

                tempList1.add(raceDriver);
                tempList2.add(position);

                raceDriver.incrementRaces();
                raceDriver.incrementPlaces(position);
                raceDriver.getPoints();
                i++;
            } else {
                i++;
                continue;
            }
        }

        Race race = new Race(dateOfRace, tempList1, tempList2);
        RACE_LIST.add(race);
        System.out.println(RACE_LIST.toString());

        for(Race r : RACE_LIST){
            System.out.println(r.getDateOfRace() + " " + r.driversOfRace + " " + r.rankingsOfRace);
        }
    }

    /**
     *
     * @param date date object
     */
    @Override
    public void updateRaceDetails() {

        Scanner userInput = new Scanner(System.in);

        if(RACE_LIST.isEmpty()){
            System.out.println("\n Race list is empty. Add a race first.");
            return;
        }

        int i = 1;
        for(Race race : RACE_LIST){
            System.out.println("\nRace No." + i + " :- " + race.getDateOfRace()
                    + "\n" + race.getDriversOfRace()
                    + "\n" + race.getRankingsOfRace());
            i++;
        }

        System.out.println("\nEnter race no. to update: ");
        String choice = userInput.next();

        try {
            int index = Integer.parseInt(choice.trim());
            System.out.println(RACE_LIST.get(index-1));

            int j = 0;
            for(Formula1Driver driver : RACE_LIST.get(index-1).getDriversOfRace()){

                System.out.println("\n——————————————————————————————————————————————————————————");
                System.out.println("Driver team : " + driver.getTeam() + "\nDriver name : " + driver.getName());
                System.out.println("——————————————————————————————————————————————————————————");

                System.out.println("Would you like to update this driver? (y/n)");
                String yesOrNo = userInput.next();

                if(yesOrNo.trim().equalsIgnoreCase("y")){
                    System.out.println("\nEnter new name to update: ");
                    String newName = userInput.next();

                    System.out.println("Enter position to update: ");
                    int newPosition = userInput.nextInt();

                    driver.setName(newName.trim());
                    RACE_LIST.get(index-1).getRankingsOfRace().set(j, newPosition);
                    driver.incrementPlaces(RACE_LIST.get(index-1).rankingsOfRace.get(j));
                    driver.getPoints();
                    DRIVER_LIST.sort(Collections.reverseOrder());
                    j++;

                } else if(yesOrNo.trim().equalsIgnoreCase("n")){
                    j++;
                    continue;
                } else {
                    System.out.println("Enter valid input.\n");
                    updateRaceDetails();
                }
            }
            return;

            } catch (NumberFormatException e) {
                System.out.println(choice + " is not a valid integer");
            }
    }

    /**
     *
     * @param race race object
     */
    @Override
    public void updateRacePoints(Race race) {
        int i = 0;
        for (Formula1Driver driver: race.driversOfRace){
            driver.incrementRaces();
            driver.incrementPlaces(race.rankingsOfRace.get(i));
            driver.getPoints();
            i++;

            for(Formula1Driver d: DRIVER_LIST){
                if(d.getName().equalsIgnoreCase(driver.getName()) && d.getTeam().equalsIgnoreCase(driver.getTeam())){
                    d.incrementRaces();
                    d.incrementPlaces(race.rankingsOfRace.get(i-1));
                    d.getPoints();
                    break;
                }
            }
        }
    }

    /**
     *
     * @param name name of driver
     * @param team team of driver
     * @return driver object
     */
    @Override
    public Formula1Driver getDriverByNameAndTeam(String name, String team) {
        Formula1Driver wantedDriver = null;
        boolean found = false;
        for (Formula1Driver driver: DRIVER_LIST) {
            if (driver.getName().equalsIgnoreCase(name) && driver.getTeam().equalsIgnoreCase(team)) {
                found = true;
                wantedDriver = driver;
                System.out.println("\n⬤ Team of driver " + driver.getName() + " changed successfully!");
                break;
            }
        }
        if(!found){
            System.out.println("\n⚠ Error. Driver doesn't exist.");
        }
        return wantedDriver;
    }

    /**
     *
     * @param fileName file name
     */
    @Override
    public void read(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Formula1Driver> tempList1; // temporary arraylist for drivers
            ArrayList<Race> tempList2; // temporary arraylist races

            tempList1 = (ArrayList<Formula1Driver>) objectInputStream.readObject();
            tempList2 = (ArrayList<Race>) objectInputStream.readObject();

            DRIVER_LIST.clear();
            RACE_LIST.clear();

            DRIVER_LIST.addAll(tempList1);
            RACE_LIST.addAll(tempList2);

            fileInputStream.close();
            objectInputStream.close();

        } catch (FileNotFoundException | EOFException e) {
            new File(file);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param fileName file name
     */
    @Override
    public void write(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(DRIVER_LIST);
            objectOutputStream.writeObject(RACE_LIST);

            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
