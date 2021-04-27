package demo;

public class Season {

    private final String name;

    private final String description;

    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static final Season SPRING = new Season("春天", "春天好啊");
    public static final Season SUMMER = new Season("夏天", "夏天好热");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬天冷啊");

    public String toString() {
        return "Season{name: " + this.name + ", description: " + this.description + "}";
    }
}
