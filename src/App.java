import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class App 
{
    public static void main(String[] args) throws Exception {
        FileReader.readPlanets();
        Astronaut astronaut = new Astronaut();
        int i = 1;
        ArrayList<Planets> planetsList = new ArrayList<Planets>();
        System.out.println("=====================================");
        System.out.println("      Space Expedition WitVerse      ");
        System.out.println("=====================================");
        System.out.println("Hello Astronaut! Welcome to your space adventure.\n TO CONTINUE, ENTER YOUR NAME: ");
        
        
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        astronaut.setName(name);

        System.out.println("Welcome to Space Expedition WitVerse.\n " +
        "Your mission is to navigate through the stars and explore new worlds!\n" +
        "Good luck, " + name + "!\n Type 'start' to begin your adventure.");


        String command = scanner.nextLine();
        while(!command.equalsIgnoreCase("start")) {
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
            + " \nyour first mission is "+ planetsList.get(1).getTaskType() + " to earn " + planetsList.get(1).getStardustReward() + " stardust. Good luck!");

            System.out.println("What has keys but can't open locks?");
            String answer = answeString();
            correctanswer(astronaut, planetsList, i);

            currentPlanet(planetsList, i);

            System.out.println("What comes once in a minute, twice in a moment, but never in a thousand years?");
            answer = answeString();
            correctanswer(astronaut, planetsList, i);

            currentPlanet(planetsList, i);
            

            System.out.println("Thank you for playing Space Expedition WitVerse. Safe travels, Astronaut " + astronaut.getName() + "!");


        scanner.close();
       
        }
        public static String answeString () {
            Scanner scanner = new Scanner(System.in);
            String answer = "";
            answer = scanner.nextLine();
            while(!answer.equalsIgnoreCase("m")) {
                System.out.println("Incorrect! Try again.");
                answer = scanner.nextLine();
            }
            return answer;
        }

        public static void correctanswer (Astronaut astronaut, ArrayList<Planets> planetsList, int i) 
        {
            System.out.println("Correct! You've earned " + planetsList.get(i).getStardustReward() + " stardust.");
            astronaut.setReward(astronaut.getReward() + planetsList.get(i).getStardustReward());
            System.out.println("Your total stardust is now: " + astronaut.getReward());

            System.out.println("Congratulations " + astronaut.getName() + "! You've completed your "+ i + " mission.");
            System.out.println("=====================================");
            System.out.println("Proceeding to your next destination...");
            System.out.println("=====================================");
            System.out.println("\n");
        }

        public static void currentPlanet ( ArrayList<Planets> planetsList, int i) {
            
            System.out.println("You have arrived at " + planetsList.get(i).getName() +
            "Your next mission is to solve "+ planetsList.get(i+1).getTaskType() + " to earn " + planetsList.get(i+1).getStardustReward() + " stardust. Good luck!\n");
            i++;

        }

    }

            