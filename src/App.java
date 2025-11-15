import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Random;

public class App { // put the type questions taken from Trivia Questions into an array list
    static ArrayList<TriviaQuestion> riddles = new ArrayList<>();
    static ArrayList<TriviaQuestion> maths = new ArrayList<>();
    static ArrayList<TriviaQuestion> logics = new ArrayList<>();
    static ArrayList<TriviaQuestion> patterns = new ArrayList<>();
    static ArrayList<TriviaQuestion> puzzles = new ArrayList<>();
    static ArrayList<TriviaQuestion> trivias = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Random random = new Random(); // randomizes the question types for the different planets they go to
        FileReader.readPlanets();
        FileReader.readTriviaQuestions();
        Astronaut astronaut = new Astronaut();
        ArrayList<TriviaQuestion> triviaQuestions = new ArrayList<TriviaQuestion>();

        triviaQuestions = (ArrayList<TriviaQuestion>) FileReader.getTriviaList(); // reads through the list of triva
                                                                                  // questions
        for (int i = 0; i < triviaQuestions.size(); i++) {
            if (triviaQuestions.get(i).getType().equalsIgnoreCase("riddle")) // if the trivia question type is riddle,
                                                                             // then it adds this question to the riddle
                                                                             // array
            {
                riddles.add(triviaQuestions.get(i));

            } else if (triviaQuestions.get(i).getType().equalsIgnoreCase("math")) // if the trivia question type is
                                                                                  // math, then it adds this question to
                                                                                  // the math array
            {
                maths.add(triviaQuestions.get(i));
            } else if (triviaQuestions.get(i).getType().equalsIgnoreCase("logic")) // if the trivia question type is
                                                                                   // logic, then it adds this question
                                                                                   // to the logic array
            {
                logics.add(triviaQuestions.get(i));
            } else if (triviaQuestions.get(i).getType().equalsIgnoreCase("pattern")) // if the trivia question type is
                                                                                     // pattern, then it adds this
                                                                                     // question to the pattern array
            {
                patterns.add(triviaQuestions.get(i));
            } else if (triviaQuestions.get(i).getType().equalsIgnoreCase("puzzle")) // if the trivia question type is
                                                                                    // puzzle, then it adds this
                                                                                    // question to the puzzle array
            {
                puzzles.add(triviaQuestions.get(i));
            } else { // no other type
                trivias.add(triviaQuestions.get(i));
            }
        }

        int i = 1;
        ArrayList<Planets> planetsList = new ArrayList<Planets>(); // menu
        System.out.println("=====================================");
        System.out.println("      Space Expedition WitVerse      ");
        System.out.println("=====================================");
        System.out.println("Hello Astronaut! Welcome to your space adventure.\n TO CONTINUE, ENTER YOUR NAME: ");

        Scanner scanner = new Scanner(System.in); // reads the user's input
        String name = scanner.nextLine();
        astronaut.setName(name);

        System.out.println("Welcome to Space Expedition WitVerse.\n " +
                "Your mission is to navigate through the stars and explore new worlds!\n" +
                "Good luck, " + name + "!\n Type 'start' to begin your adventure."); // type name

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("start")) { // type start
            System.out.println("Invalid command. Please type 'start' to begin your adventure.");
            command = scanner.nextLine();
        }

        System.out.println();
        System.out.println("You have started your adventure, " + astronaut.getName() + "!");
        System.out.println("=====================================");
        System.out.println();
        System.out.println("Here are the places that you'll explore:");
        planetsList = (ArrayList<Planets>) FileReader.getPlanetsList();
        System.out.println("=====================================");

        System.out.println("\n");

        for (Planets planet : planetsList) {
            System.out.println("-------------------------------------");
            System.out.println(planet.toString());

        }
        System.out.println();
        System.out.println("\n");
        System.out.println("So now you are in the " + planetsList.get(0).getName() +
                ". You need to complete a mission and earn rewards to go to your next destination:");
        System.out.println("\n");

        System.out.println("You can now proceed to your first mission!"
                + " \nyour first mission is " + planetsList.get(0).getTaskType() + " to earn "
                + planetsList.get(0).getStardustReward() + " stardust. Good luck!");
        System.out.println("\n");

        for (i = 1; i < planetsList.size() - 1; i++) {
            System.out.println("=====================================");
            randomQuestion(planetsList, astronaut, i, random);
            System.out.println("Hit cancel to stop or any other key to continue");
            String continueCommand = scanner.nextLine();
            if (continueCommand.equalsIgnoreCase("cancel")) {
                break;
            }
            currentPlanet(planetsList, i);

        }

        System.out.println("Thank you for playing Space Expedition WitVerse. Safe travels, Astronaut "
                + astronaut.getName() + "!");

        scanner.close();

    }

    public static String answerString() {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        answer = scanner.nextLine();
        return answer;
    }

    public static void correctanswer(Astronaut astronaut, ArrayList<Planets> planetsList, int i) {
        System.out.println("Correct! You've earned " + planetsList.get(i).getStardustReward() + " stardust.");
        astronaut.setReward(astronaut.getReward() + planetsList.get(i).getStardustReward());
        System.out.println("Your total stardust is now: " + astronaut.getReward());

        System.out.println("Congratulations " + astronaut.getName() + "! You've completed your " + i + " mission.");
        System.out.println("=====================================");
        System.out.println("Proceeding to your next destination...");
        System.out.println("=====================================");
        System.out.println("\n");
    }

    public static void currentPlanet(ArrayList<Planets> planetsList, int i) {

        System.out.println("You have arrived at " + planetsList.get(i).getName() +
                "Your next mission is to solve " + planetsList.get(i + 1).getTaskType() + " to earn "
                + planetsList.get(i + 1).getStardustReward() + " stardust. Good luck!\n");
        i++;

    }

    public static List<String> typeQuestion(ArrayList<TriviaQuestion> triviaQuestions, int i) {
        // Get the type of the question at index i
        String type = triviaQuestions.get(i).getType();
        ArrayList<String> filteredQuestions = new ArrayList<>();
        for (TriviaQuestion q : triviaQuestions) {
            if (q.getType().equalsIgnoreCase(type)) {
                filteredQuestions.add(q.getQuestion());
            }
        }
        return filteredQuestions;
    }

    public static void randomQuestion(ArrayList<Planets> planetsList, Astronaut astronaut, int i, Random random) {

        if (planetsList.get(i).getTaskType().equalsIgnoreCase("riddle")) {
            System.out.println("\n");
            int randomIndex = random.nextInt(riddles.size());
            riddles.get(randomIndex);
            System.out.println(riddles.get(randomIndex).getQuestion());

            String answer = answerString();
            if (answer.equalsIgnoreCase(riddles.get(randomIndex).getAnswer())) {
                correctanswer(astronaut, planetsList, i);
            } else {
                while (!answer.equalsIgnoreCase(riddles.get(randomIndex).getAnswer())) {
                    System.out.println("Incorrect! Try again.");
                    answer = answerString();
                }

            }
            System.out.println("\n");
        } else if (planetsList.get(i).getTaskType().equalsIgnoreCase("math")) {
            System.out.println("\n");

            int randomIndex = random.nextInt(maths.size());
            System.out.println(maths.get(randomIndex));
            System.out.println(maths.get(randomIndex).getQuestion());

            String answer = answerString();
            if (answer.equalsIgnoreCase(maths.get(randomIndex).getAnswer())) {
                correctanswer(astronaut, planetsList, i);
            } else {
                while (!answer.equalsIgnoreCase(maths.get(randomIndex).getAnswer())) {
                    System.out.println("Incorrect! Try again.");
                    answer = answerString();
                }

            }
            System.out.println("\n");
        } else if (planetsList.get(i).getTaskType().equalsIgnoreCase("logic")) {
            System.out.println("\n");
            int randomIndex = random.nextInt(logics.size());
            System.out.println(logics.get(randomIndex).getQuestion());

            System.out.println("\n");
            String answer = answerString();
            System.out.println("\n");
            if (answer.equalsIgnoreCase(logics.get(randomIndex).getAnswer())) {
                System.out.println("\n");
                correctanswer(astronaut, planetsList, i);
            } else {
                while (!answer.equalsIgnoreCase(logics.get(randomIndex).getAnswer())) {
                    System.out.println("Incorrect! Try again.");
                    answer = answerString();
                }

            }
            System.out.println("\n");
        } else if (planetsList.get(i).getTaskType().equalsIgnoreCase("pattern")) {
            System.out.println("\n");
            int randomIndex = random.nextInt(patterns.size());
            System.out.println(patterns.get(randomIndex).getQuestion());

            String answer = answerString();
            if (answer.equalsIgnoreCase(patterns.get(randomIndex).getAnswer())) {
                correctanswer(astronaut, planetsList, i);
            } else {
                while (!answer.equalsIgnoreCase(patterns.get(randomIndex).getAnswer())) {
                    System.out.println("Incorrect! Try again.");
                    answer = answerString();
                }

            }
            System.out.println("\n");
        } else if (planetsList.get(i).getTaskType().equalsIgnoreCase("puzzle")) {
            System.out.println("\n");
            int randomIndex = random.nextInt(puzzles.size());
            System.out.println(puzzles.get(randomIndex).getQuestion());

            String answer = answerString();
            if (answer.equalsIgnoreCase(puzzles.get(randomIndex).getAnswer())) {
                correctanswer(astronaut, planetsList, i);
            } else {
                while (!answer.equalsIgnoreCase(puzzles.get(randomIndex).getAnswer())) {
                    System.out.println("Incorrect! Try again.");
                    answer = answerString();
                }

            }
            System.out.println("\n");
        } else {
            System.out.println("\n");
            int randomIndex = random.nextInt(trivias.size());
            System.out.println(trivias.get(randomIndex).getQuestion());

            String answer = answerString();
            if (answer.equalsIgnoreCase(trivias.get(randomIndex).getAnswer())) {
                correctanswer(astronaut, planetsList, i);
            } else {
                while (!answer.equalsIgnoreCase(puzzles.get(randomIndex).getAnswer())) {
                    System.out.println("Incorrect! Try again.");
                    answer = answerString();
                }

            }
            System.out.println("\n");
        }

    }

}
