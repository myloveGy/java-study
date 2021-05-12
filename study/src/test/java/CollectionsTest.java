import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        Collections.reverse(list);

        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);

        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
    }
}
