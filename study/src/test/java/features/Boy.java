package features;

public class Boy {
    public String name;

    private Girl girl;

    public Boy(String name) {
        this.name = name;
    }

    public Girl getGirl() {
        return girl;
    }
}
