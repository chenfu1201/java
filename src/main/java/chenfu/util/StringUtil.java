package chenfu.util;

import java.util.Base64;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/3/2 19:08
 */
public class StringUtil {

    //    盐值
    private final static String SALT = "{salt}";

    //    加密次数
    private final static Integer TIMES = 3;

    /**
     * 加密方法
     *
     * @param pwd
     * @return
     */
    public static String encode(String pwd) {
        pwd += SALT;
        byte p[] = pwd.getBytes();
        for (int i = 0; i < TIMES; i++) {
            p = Base64.getEncoder().encode(p);
        }
        return new String(p);
    }

    /**
     * 解密方法
     *
     * @param pwd
     * @return
     */
    public static String decode(String pwd) {
        byte[] bytes = pwd.getBytes();
        for (int i = 0; i < TIMES; i++) {
            bytes = Base64.getDecoder().decode(bytes);
        }
        return new String(bytes).replaceAll("\\{\\w+\\}", "");
    }

    public static void main(String[] args) {
        String string = "臣服Romantic";
        String encode = encode(string);
        System.out.println(encode);
        String decode = decode(encode);
        System.out.println(decode);
    }
}
