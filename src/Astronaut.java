public class Astronaut {

    private String name;
    private int reward;

    // create an identifier for name, reward, and location
    public Astronaut(String name, int reward) {
        super();
        this.name = name;
        this.reward = reward;

    }
    public Astronaut() {
        this.name = "";
        this.reward = 0;
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
