import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static Formula1ChampionshipManager championshipManager = new Formula1ChampionshipManager();
    public static String file = "championshipDetails.ser";

    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            championshipManager.read(file);
            menu();
        } catch (Exception e){
            System.out.println("\n⚠ Error occured. Please retry");
            menu();
        }
        championshipManager.read(file);
        menu();
    }

    /**
     *
     * @return validate user input
     */
    public static int inputValidator() throws IOException, ClassNotFoundException {
        int validated = 0;
        try {
            Scanner keyboardInput = new Scanner (System.in);
            System.out.println("\nEnter option: ");
            int choice = keyboardInput.nextInt();


    //        try {
            if(choice > 0 && choice < 11){
                validated = choice;
            } else {
                System.out.println("\n⚠ Error. Invalid number.");
                menu();
            }
        } catch (Exception e){
            System.out.println("\n⚠ Error occurred. Re-enter input");
            menu();
        }
        return validated;
    }

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void menu() throws IOException, ClassNotFoundException {
        System.out.println("\n—————————————————————————————————— FORMULA ONE CHAMPIONSHIP ——————————————————————————————————");
        System.out.println("\n-- Choose an option -- \n");
        System.out.println("⬤ Press 1 to add new driver.");
        System.out.println("⬤ Press 2 to remove driver.");
        System.out.println("⬤ Press 3 to update a driver.");
        System.out.println("⬤ Press 4 to display statistics of a driver");
        System.out.println("⬤ Press 5 to display championship Table");
        System.out.println("⬤ Press 6 to add race");
        System.out.println("⬤ Press 7 to update race details");
        System.out.println("⬤ Press 8 to load from file.");
        System.out.println("⬤ Press 9 to to save to file.");
        System.out.println("⬤ Press 10 to quit.");

        int choice = inputValidator();
        runProgram(choice);
    }

    /**
     *
     * @param choiceNum option selected
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void runProgram(int choiceNum) throws IOException, ClassNotFoundException {
        Scanner userInput = new Scanner (System.in);

        while(true){
            switch(choiceNum){
                case 1:
                    System.out.println("\n—————————————————————————————————— ADD DRIVER ——————————————————————————————————");
                    championshipManager.read(file);
                    System.out.println("\nName of driver: ");
                    String name = userInput.next();

                    System.out.println("Location of driver: ");
                    String location = userInput.next();

                    System.out.println("Team of driver: ");
                    String team = userInput.next();

                    championshipManager.add(name.trim(), location.trim(), team.trim());
                    championshipManager.write(file);
                    menu();
                    break;

                case 2:
                    System.out.println("\n—————————————————————————————————— DELETE DRIVER ——————————————————————————————————");
                    championshipManager.read(file);
                    System.out.println("\nName of driver: ");
                    String nameToDelete = userInput.next();

                    System.out.println("Team of driver: ");
                    String teamToDelete = userInput.next();

                    championshipManager.delete(nameToDelete.trim(), teamToDelete.trim());
                    championshipManager.write(file);
                    menu();
                    break;

                case 3:
                    System.out.println("\n—————————————————————————————————— UPDATE DRIVER ——————————————————————————————————");
                    championshipManager.read(file);
                    System.out.println("\nName of driver: ");
                    String nameToUpdate = userInput.next();

                    System.out.println("Current team of driver: ");
                    String currentTeam = userInput.next();

                    System.out.println("New team of driver: ");
                    String newTeam = userInput.next();

                    championshipManager.changeTeam(nameToUpdate.trim(), currentTeam.trim(), newTeam.trim());
                    championshipManager.write(file);
                    menu();
                    break;

                case 4:
                    System.out.println("\n—————————————————————————————————— DISPLAY DRIVER STATS ——————————————————————————————————");
                    championshipManager.read(file);
                    System.out.println("\nName of driver: ");
                    String nameForStats = userInput.next();

                    System.out.println("Team of driver: ");
                    String teamForStats = userInput.next();

                    System.out.println(championshipManager.displayStats(nameForStats.trim(), teamForStats.trim()));
                    menu();
                    break;

                case 5:
                    System.out.println(championshipManager.showFormula1Table());
                    menu();
                    break;

                case 6:
                    System.out.println("\n—————————————————————————————————— ADD RACE ——————————————————————————————————");
                    try{
                        championshipManager.read(file);
                        championshipManager.addRace();
                        championshipManager.write(file);
                        menu();
                    } catch (Exception e){
                        System.out.println(e);
                        System.out.println("\n⚠ Error. Re-enter details.");
                        menu();
                    }
                    championshipManager.write(file);
                    break;

                case 7:
                    System.out.println("\n—————————————————————————————————— UPDATE RACE ——————————————————————————————————");
                    championshipManager.read(file);
                    championshipManager.updateRaceDetails();
                    championshipManager.write(file);
                    menu();
                    break;

                case 8:
                    System.out.println("\n\uD83D\uDD14 Reading file....");
                    championshipManager.read(file);
                    menu();
                    break;

                case 9:
                    System.out.println("\n\uD83D\uDD14 Saving file....");
                    championshipManager.write(file);
                    menu();
                    break;

                case 10:
                    championshipManager.write(file);
                    System.out.println("\n\uD83D\uDD14 Program exiting....");
                    System.exit(0); // exit program
                    break;
            }
        }
    }

}
