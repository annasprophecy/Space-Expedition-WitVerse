import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private static List<Planets> planetsList = new ArrayList<>();
    private static List<TriviaQuestion> triviaQuestion = new ArrayList<>();
    private static String universeFilePath = "src/universe.txt";
    private static String tasksFilePath = "src/tasks.txt";

    public static void readPlanets() {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(universeFilePath));

            String line;
            for (int i = 0; (line = br.readLine()) != null; i++) {
                if (i == 0)
                    continue;
                String[] parts = line.split(",", 5);
                if (parts.length < 5)
                    continue;

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

    public static void readTriviaQuestions() {

        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(tasksFilePath)); // use

            String line;
            for (int i = 0; (line = br.readLine()) != null; i++) {
                if (i == 0)
                    continue; // skips first line
                String[] parts = line.split(",");

                String type = parts[0].trim();
                String question = parts[1].trim();
                String answer = parts[2].trim();
                TriviaQuestion trivia = new TriviaQuestion(type, question, answer);
                triviaQuestion.add(trivia);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

}
