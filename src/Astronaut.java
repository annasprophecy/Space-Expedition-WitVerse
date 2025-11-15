public class Astronaut {

    private String name;
    private int reward;
    private String location;

    // create an identifier for name, reward, and location
    public Astronaut(String name, int reward, String location) {
        super();
        this.name = name;
        this.location = location;
        this.reward = reward;

    }

    public Astronaut() {
        super();
        this.name = "unknown";
        this.location = "unknown";
        this.reward = 0;

    }

    public Astronaut(int reward) {
        super();
        this.name = name;
        this.reward = 0;
        this.location = "unknown";

    }

    public Astronaut(String name) {
        super();
        this.name = "unknown";
        this.reward = reward;
        this.location = location;

    }

    public Astronaut(String location) {
        super();
        this.location = "unknown";
        this.reward = reward;
        this.name = name;

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
