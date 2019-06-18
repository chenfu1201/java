package chenfu.lang;

import chenfu.util.Print;
import org.junit.Test;

import java.math.BigInteger;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

import static chenfu.util.Print.*;
/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/17 20:41
 */
public class IntegerTest {

    @Test
    public void run() {
        Scanner input = new Scanner(System.in);
        print(Integer.MAX_VALUE);
        print(Integer.MAX_VALUE+1);
        print(Integer.MAX_VALUE+1000);
        print(DateFormat.getDateTimeInstance().format(new Date(Integer.MAX_VALUE*1000L)));
        print(Integer.MIN_VALUE);
        System.out.println("long");
        print(Long.MAX_VALUE);
        print(Long.MAX_VALUE+1);
        print(Long.MAX_VALUE+10000);
        System.out.println("big");
        print(new BigInteger("9993372036854775807"));
        print(Long.MIN_VALUE);
        print(Integer.max(100,29));

    }

}
