package chenfu.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/9 15:27
 */
public class ThreadTest {

//    测试Callable接口相关

    /**
     * 测试Callable接口
     */
    @Test
    public void run1() throws Exception {
        MyCallable callable = new MyCallable();
        FutureTask<String> task = new FutureTask<String>(callable);
        new Thread(task).start();
        System.out.println(task.get());
    }

    /**
     * 函数式编程
     */
    @Test
    public void run2() throws Exception {
        FutureTask<String> task = new FutureTask<>(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "..." + i);
            }
            return "程序结束";
        });
        new Thread(task).start();
        System.out.println(task.get());
    }

    //    测试Runnable接口相关
    @Test
    public void run3() throws Exception {
        MyRunnable tickets = new MyRunnable(100);
        new Thread(tickets, "1号售票口出售票号---").start();
        new Thread(tickets, "2号售票口出售票号---").start();
        new Thread(tickets, "3号售票口出售票号---").start();
        new Thread(tickets, "4号售票口出售票号---").start();

        Thread.sleep(1000);
    }

    @Test
    public void run4() throws ExecutionException, InterruptedException {
        TicketCallable tickets = new TicketCallable(100);
        FutureTask<Boolean> task = new FutureTask(tickets);
        new Thread(task, "1号售票口出售票号---").start();
        new Thread(new FutureTask(tickets), "2号售票口出售票号---").start();
        new Thread(new FutureTask(tickets), "3号售票口出售票号---").start();
        new Thread(new FutureTask(tickets), "4号售票口出售票号---").start();
        if (task.get()) {
            System.out.println("over!");
        }
    }

    public void run5() {
        String sbc="abca";
        sbc.toCharArray();
    }

    public class TicketCallable implements Callable<Boolean> {

        private Integer tickets;

        public TicketCallable(Integer tickets) {
            this.tickets = tickets;
        }

        @Override
        public Boolean call() throws Exception {
            while (this.tickets > 0) {
                synchronized (this) {
                    if (this.tickets > 0) {
                        System.out.println(Thread.currentThread().getName() + this.tickets--);
                    }
                    if (this.tickets == 0) {
                        return true;
                    }
                }
            }
            return true;
        }
    }
}
