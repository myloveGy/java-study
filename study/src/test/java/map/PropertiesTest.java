package map;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        props.load(fis);
        String name = props.getProperty("username");
        System.out.println(name);
        System.out.println(props.getProperty("age"));
        System.out.println(props.getProperty("hello"));
        fis.close();
    }
}
