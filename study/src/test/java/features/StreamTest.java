package features;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("jinxing.liu");
        list.add("username");
        list.add("测试");
        list.add("my name is hello world!");

        Stream<String> stringStream = list.stream();
        stringStream.filter(n -> !n.equals("测试")).sorted().limit(2).forEach(System.out::println);
        System.out.println(list);

        System.out.println(stringStream);

        // 😁 测试啊
        final IntStream stream = Arrays.stream(new int[]{1, 2, 3});
        System.out.println(stream);
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("aa", "bc", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        list.stream().map(s -> s + "abc").map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(2021, 5, 14, 15, 15);

        // 是否满足条件
        System.out.println(list.stream().allMatch(integer -> integer >= 15));    // 全部 >= 15
        System.out.println(list.stream().anyMatch(integer -> integer == 2021));  // 有一个 = 2021
        System.out.println(list.stream().noneMatch(integer -> integer == 2020)); // 没有一个 = 2020

        System.out.println(list.parallelStream().findAny());

        System.out.println(list.stream().filter(integer -> integer >= 15).count());

        List<String> list1 = new ArrayList<>();
        list.stream().map(integer -> integer * 5).forEach(integer -> list1.add(integer.toString()));
        System.out.println(list1);
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce(Integer::sum));

        List<Person> personList = Arrays.asList(new Person("jinxing.liu", 10), new Person("haha", 15));
        System.out.println(personList.stream().map(person -> person.age).reduce(Integer::sum));

        Set<Person> collect = new HashSet<>(personList);
        for (Person p : collect) {
            System.out.println(p);
        }
    }

    static class Person {
        public String name;

        public Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
