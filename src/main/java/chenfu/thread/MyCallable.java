package chenfu.thread;

import java.util.concurrent.Callable;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/9 15:20
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "..." + i);
        }
        return "function over!";
    }

}
