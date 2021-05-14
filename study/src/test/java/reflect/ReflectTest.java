package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

    @Test
    public void test() {
        Person person = new Person("jinxing.liu", 10);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person);

        person.setAge(100);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person);
    }

    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Person> objectClass = Person.class;
        Constructor<Person> cons = objectClass.getConstructor(String.class, int.class);
        Person person = cons.newInstance("username", 10);
        System.out.println(person);

        Field name = objectClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "jinxing.liu");
        System.out.println(person);
    }

    @Test
    public void test2() throws ClassNotFoundException {

        // 方式一: 调用运行时类的属性
        Class<Person> classPerson = Person.class;
        System.out.println(classPerson);

        // 方式二：调用运行时类的方法 getClass()
        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();
        System.out.println(personClass2);

        // 方式三: 通过Class的静态方法
        Class<?> personClass3 = Class.forName("reflect.Person");
        System.out.println(personClass3);

        System.out.println(classPerson == personClass3);
        System.out.println(personClass2 == personClass3);
    }
}
