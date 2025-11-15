import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        FileReader.readPlanets();
        Astronaut astronaut = new Astronaut();
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

        if (command.equalsIgnoreCase("start")) {
            System.out.println("you have started your adventure, " + astronaut.getName() + "!");

            
        } else {
            System.out.println("Invalid command. Please restart the application to try again.");
        }
        
    }
}
