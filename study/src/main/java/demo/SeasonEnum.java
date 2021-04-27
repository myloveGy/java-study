package demo;

interface Name {
    String getName();
}

enum SeasonEnum implements Name {

    SPRING("春天", "春天好啊"),
    SUMMER("夏天", "夏天好热"),
    AUTUMN("秋天", "秋高气爽"),
    WINTER("冬天", "冬天冷啊");

    private final String name;

    private final String description;

    SeasonEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
