package demo;

import org.junit.Test;

public class SeasonTest {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println(season);
    }

    @Test
    public void testSeasonEnum() {
        SeasonEnum seasonEnum = SeasonEnum.AUTUMN;
        System.out.println(seasonEnum);
        System.out.println(seasonEnum.getDescription());
        System.out.println(seasonEnum.getName());
        System.out.println(SeasonEnum.class.getSuperclass());

        SeasonEnum[] values = SeasonEnum.values();
        for (SeasonEnum value : values) {
            System.out.println(value);
        }

        System.out.println(SeasonEnum.valueOf("WINTER").getName());
    }
}