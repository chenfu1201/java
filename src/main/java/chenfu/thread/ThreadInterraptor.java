package chenfu.thread;

import org.junit.Test;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/10 15:48
 */
public class ThreadInterraptor {


    @Test
    public void run1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("忙了一天了，我要好好休息一下！");
            for (int i = 0; i < 10; i++) {
//                休眠10秒
                try {
                    System.out.println("睡觉ing....");
                    Thread.sleep(10000);
//                    InterruptedException线程中断异常，必须处理或抛出
                } catch (InterruptedException e) {
                    System.out.println("打扰我休息！我砍死你！");
                }
                System.out.println(Thread.currentThread().getName() + i);
            }
            System.out.println("终于睡饱了！");
        });
        thread.start();
        Thread.sleep(5000);
//        thread.isInterrupted() 判断线程是否被中断！
//        被中断返回true，反之返回false
        if (!thread.isInterrupted()) {
//            中断子线程
            System.out.println("别睡了，哥们！起来干活");
            thread.interrupt();
        }
    }

}
