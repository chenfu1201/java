package chenfu.list;

import org.junit.Test;

import java.util.*;

import static chenfu.util.Print.*;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 11:07
 */
public class MapTest {

    @Test
    public void print1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(111, "111");
        map.put(222, "222");
        map.put(444, "444");
        map.put(333, "333");
        map.put(333, "333");
        map.put(null, null);
        print(map);

        /**
         * ConcurrentModificationException
         */
        Set<Integer> keySet = map.keySet();
        for (Integer integer : keySet) {
            if (integer == null) {
                map.remove(integer);
            }
        }
        print("modify:", map);
    }

    @Test
    public void print2() {
        Map<Integer, String> map = new HashMap<>();
        map.put(111, "111");
        map.put(222, "222");
        map.put(444, "444");
        map.put(333, "333");
        map.put(333, "333");
        map.put(null, null);
        print(map);

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry : set) {

        }
    }
}
