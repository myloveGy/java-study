package collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

class Person {
    private Integer age;

    private String name;

    public Person(String name, Integer a) {
        this.name = name;
        this.age = a;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class SetTest {
    @Test
    public void test() {
        HashSet<Object> set = new HashSet<>();
        set.add(456);
        set.add(123);
        set.add("7890");
        set.add(456);
        set.add(123);
        set.add("7890");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        TreeSet<String> set = new TreeSet<>();
        set.add("123"); // 关键字
        set.add("456");
        set.add("789");
        System.out.println(set);
    }

    @Test
    public void test3() {
        HashSet<Object> set = new HashSet<>();
        Person p1 = new Person("jinxing.liu", 1);
        Person p2 = new Person("hello world", 2);
        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.setName("123456");
        System.out.println(set);
        set.remove(p1);
        System.out.println(set);
        System.out.println(p1);

    }
}
