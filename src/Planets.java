public enum Planets {
    MILKY_WAY("Milky Way", "Home to Planet Earth - the best planet ever", 0, "riddle"),
    AETHER_1("Aether-1", "Shimmering world of floating islands", 3, "math"),
    CRIMSON_VOID("Crimson Void", "Dark universe filled with shifting fog", 5, "trivia"),
    LUMINA_9("Lumina-9", "Bright crystalline realm full of energy", 7, "pattern"),
    NEBULON_GATE("Nebulon Gate", "Portal-heavy realm with unstable space", 10, "riddle"),
    ZERO_POINT("Zero Point", "Quiet universe hiding ancient secrets", 6, "math"),
    OBSIDIAN_CORE("Obsidian Core", "Metallic lava world with hostile storms", 8, "logic"),
    ECHOTRAIL("Echotrail", "Universe where past choices echo into events", 6, "trivia"),
    STARWELL("Starwell", "Collapsed star remnant full of rare minerals", 10, "math"),
    VERDANT_SPIRAL("Verdant Spiral", "Endless green spiral forests", 8, "puzzle"),
    FROST_SENTINEL("Frost Sentinel", "Snow-covered universe guarded by AI constructs", 10, "riddle");

    private final String name;
    private final String description;
    private final int travelCost;
    private final String taskType;

    Planets(String name, String description, int travelCost, String taskType) {
        this.name = name;
        this.description = description;
        this.travelCost = travelCost;
        this.taskType = taskType;
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
}













