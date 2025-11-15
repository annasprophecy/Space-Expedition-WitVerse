import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class TriviaQuestion {

    private String type;
    private String question;
    private String answer;

    private TriviaQuestion(String type, String question, String answer) {
    this.type = type;
    this.question = question;
    this.answer = answer;
}
    private TriviaQuestion() {
    this.type = "unknown";
    this.question = "unknown";
    this.answer = "unknown";
}
 


    ArrayList<TriviaQuestion> triviaQuestions = new ArrayList<>();

    //read question type, question, and answer from tasks.txt

    Scanner scannerTasks = new Scanner(new File("tasks.txt"));

    scannerTasks.nextLine(); // skip header line

    while(scannerTasks.hasNextLine()) {

        String newStr = scannerTasks.nextLine().trim(); // makes line into a string
        String[] split = newStr.split(","); // makes string into an array split by commas

        String type = split [0]; //split[0-...] takes the value after the split, so [math, what..., 41], it'll take "math" since math at 0
        String question = split [1];
        String answer = split[2]; //it's a string instead of a int because you're not using it to calculate anyting

        triviaQuestions.add(new TriviaQuestion(type, question, answer));
    }
    

    // method that gets question and reward



}