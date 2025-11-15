public class Planets {
    private final String name;
    private final String description;
    private final int travelCost;
    private final String taskType;
    private final int stardustReward;

    public Planets(String name, String description, int travelCost, String taskType, int stardustReward) {
        this.name = name;
        this.description = description;
        this.travelCost = travelCost;
        this.taskType = taskType;
        this.stardustReward = stardustReward;
    }
    public Planets() {
        this.name = "";
        this.description = "";
        this.travelCost = 0;
        this.taskType = "";
        this.stardustReward = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTravelCost() {
        return travelCost;
    }

    public String getTaskType() {
        return taskType;
    }

    public int getStardustReward() {
        return stardustReward;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Cost: %d, Task: %s, Reward: %d",
                name, description, travelCost, taskType, stardustReward);
    }
}
