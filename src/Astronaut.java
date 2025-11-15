public class Astronaut {

    private String name;
    private int reward;

    public Astronaut(String name, int reward) {
        super();
        this.name = name;
        this.reward = reward;

    }

    public Astronaut() {
        super();
        this.name = "unknown";
        this.reward = 0;

    }

    public Astronaut(int reward) {
        super();
        this.name = name;
        this.reward = 0;

    }

    public Astronaut(String name) {
        super();
        this.name = "unknown";
        this.reward = reward;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
