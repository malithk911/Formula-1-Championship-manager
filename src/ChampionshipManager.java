import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ChampionshipManager {

    static final List<Formula1Driver> DRIVER_LIST = new ArrayList<>();
    static final List<Race> RACE_LIST = new ArrayList<>();

    void add(String name, String location, String team) throws IOException, ClassNotFoundException;
    void show();
    void delete(String name, String team);
    void changeTeam(String name, String currentTeam, String newTeam);
    String displayStats(String name, String team);
    String showFormula1Table();
    void addRace();
    void updateRaceDetails();
    void updateRacePoints(Race race);
    Formula1Driver getDriverByNameAndTeam(String name, String team);
    void read(String fileName);
    void write(String fileName);
}
