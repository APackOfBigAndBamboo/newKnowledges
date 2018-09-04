package ThreadDemo;

/**
 * @Derscription TODO
 * @auther David
 * @date 2018-09-03 15:16
 * @Version 1.o
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyThread1 mt = new MyThread1();
        new Thread(mt, "票贩子1").start();
        new Thread(mt, "票贩子2").start();
        new Thread(mt, "票贩子3").start();
    }

}

class MyThread1 implements Runnable {
    private volatile int ticket = 10;//直接内存操作
    @Override
    public void run() {
        synchronized (this) {
            while (this.ticket > 0) {
                try {
                    Thread.sleep(1);//模拟网络延迟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ",.ticket=" + this.ticket--);
            }
        }
    }
}