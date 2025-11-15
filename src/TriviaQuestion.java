
public class TriviaQuestion {

    private String type;
    private String question;
    private String answer;

    public TriviaQuestion(String type, String question, String answer) {
        this.type = type;
        this.question = question;
        this.answer = answer;
    }
    public TriviaQuestion() {
        this.type = "";
        this.question = "";
        this.answer = "";
    }
    
    public String getType() {
        return type;

    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {

        return String.format("%s : %s?, %s", type, question, answer);

    }
}

// method that gets question, then when the question is correct, it increments,
// but if it's wrong it makes you do it again.
