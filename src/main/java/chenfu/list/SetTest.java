package chenfu.list;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 10:55
 */
public class SetTest {

    @Test
    public void print1() {
        HashSet<Integer> set = new HashSet<>();
        set.add(121);
        set.add(121);
        set.add(178);
        set.add(290);
        set.add(256);
        set.add(256);
        System.out.println(set);

        for (Integer integer : set) {
            System.out.println(integer);
            /**
             * ConcurrentModificationException
             */
//            set.remove(integer);
        }
        System.out.println("xxx");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            /**
             * ConcurrentModificationException
             */
            set.remove(next);
        }
        System.out.println("modify:");
        System.out.println(set);
    }
}
