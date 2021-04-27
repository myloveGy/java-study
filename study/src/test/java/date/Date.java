package date;

import org.junit.Test;

import java.time.*;

public class Date {
    @Test
    public void test() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(localDate);
        System.out.println(localTime);

        //
        Instant now = Instant.now();
        System.out.println(now);

        // 当前本地时间
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
}
