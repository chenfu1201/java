package chenfu.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/5/17 16:36
 */
public class LIstTest {

    /**
     * 集合的遍历方式
     */

    @Test
    public void print1() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(56);
        list.add(78);
        list.add(45);
        System.out.println(list);
        /**
         * ConcurrentModificationException
         */
        for (Integer integer : list) {
            if (list.indexOf(integer) % 2 == 0) {
//                list.remove(integer);
                list.add(111);
            }
        }
        System.out.println("modify:");
        System.out.println(list);
    }

    @Test
    public void print2() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(56);
        list.add(78);
        list.add(45);
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        /**
         * ConcurrentModificationException
         */
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (list.indexOf(next) % 2 == 0) {
                list.remove(next);
//                list.add(111);
            }
        }
        System.out.println("modify:");
        System.out.println(list);
    }

    @Test
    public void print3() {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(56);
        list.add(78);
        list.add(45);
        System.out.println(list);
        for (int index = 0; index < list.size(); index++) {
            if (index % 2 == 0) {
//                list.remove(index);
                list.add(121);
            }
        }
        System.out.println("modify:");
        System.out.println(list);
    }

}
