import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static List<Planets> planetsList = new ArrayList<>();
    private static String filePath = "src/universe.txt";
    
    public static void readPlanets() {
        try{
            BufferedReader br = new BufferedReader(new java.io.FileReader(filePath));

            String line;
            for (int i = 0; (line = br.readLine()) != null; i++) {
                if (i == 0) continue;
                String[] parts = line.split(",", 5);
                if (parts.length < 5) continue;

                String name = parts[0].trim();
                String description = parts[1].trim();
                int travelCost = Integer.parseInt(parts[2].trim());
                String taskType = parts[3].trim();
                int stardustReward = Integer.parseInt(parts[4].trim());

                Planets planet = new Planets(name, description, travelCost, taskType, stardustReward);
                planetsList.add(planet);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static List<Planets> getPlanetsList() {
        return planetsList;
    }
}
