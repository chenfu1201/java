package chenfu.tree;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/13 11:38
 */
public class StaticTest {

    private static String MSG = "msg";

    private static Integer MAX = Integer.MAX_VALUE;

//    private static Integer CUSTOM;

    private static int CUSTOM;

    public static void main(String[] args) {
        System.out.println(StaticTest.MSG);
        System.out.println(StaticTest.MAX);
        System.out.println(StaticTest.CUSTOM);
    }
}
