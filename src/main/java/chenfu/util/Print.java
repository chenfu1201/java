package chenfu.util;

import java.util.Arrays;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/18 11:07
 */
public class Print {

    public static void print(Object object) {
        if (object.getClass().isArray()) {
            Object[] obj = (Object[]) object;
            System.out.println(Arrays.toString(obj));
            return;
        }
        System.out.println(object);
    }

    public static void print(Object str, Object object) {
        System.out.println(str);
        if (object.getClass().isArray()) {
            Object[] obj = (Object[]) object;
            System.out.println(Arrays.toString(obj));
            return;
        }
        System.out.println(object);
    }
}
