package chenfu.thread;

/**
 * @Author: romantic_ke@163.com
 * @Description:
 * @Date: 2019/6/9 17:41
 */
public class MyRunnable implements Runnable {

    private Integer ticket;

    public MyRunnable(Integer ticket) {
        this.ticket = ticket;
    }

    @Override
    public synchronized void run() {
        while (ticket > 0) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + this.ticket--);
            }
        }
    }
}
