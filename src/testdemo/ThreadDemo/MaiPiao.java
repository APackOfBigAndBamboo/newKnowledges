package testdemo.ThreadDemo;

/**
 * @Derscription 多线程模拟抢票机制
 * @auther David
 * @date 2018-09-03 9:49
 * @Version 1.o
 */
class MyThread implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (this.sale()) {//每一次只允许一个县城进行访问
        }
    }

    public synchronized boolean sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(1);//模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",.ticket=" + this.ticket--);
            return true;
        } else {
            System.out.println("****票已经卖光了*****");
            return false;
        }
    }
}

public class MaiPiao {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "票贩子A").start();
        new Thread(mt, "票贩子B").start();
        new Thread(mt, "票贩子C").start();
    }
}
