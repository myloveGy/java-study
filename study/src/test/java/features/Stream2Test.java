package features;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream2Test {

    @Test
    public void test() {
        List<String> list = List.of("123", "456", "789");
        list.stream().takeWhile(x -> !x.equals("456")).forEach(System.out::println);
    }

    @Test
    public void test1() {
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);

        // java9 方法重载
        Stream.iterate(0, x -> x < 100, x -> x  + 1).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("jinxing.liu", "hello", "world");
        Optional<List<String>> optional = Optional.ofNullable(list);
        optional.stream().flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
