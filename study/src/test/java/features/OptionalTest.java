package features;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test() {
        Boy boy = new Boy("jinxing.liu");
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        System.out.println(optionalBoy.orElse(new Boy("test")).name);
//        System.out.println(optionalBoy.get());
    }

    public String getBoyName(Boy boy) {
        return boy.getGirl().getName();
    }
}
