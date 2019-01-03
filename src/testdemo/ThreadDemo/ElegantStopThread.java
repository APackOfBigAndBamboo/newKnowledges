package testdemo.ThreadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * TODO: 优雅的停止线程和 守护线程 demo
 * @author David
 * @date 2018-09-03 14:48
 * @version 1.o
 */
public class ElegantStopThread {
    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        Thread userThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行，num=" + i);
            }
        }, "用户线程");
        Thread daemonThread = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在运行，num=" + i);
            }
        }, "守护线程");
        daemonThread.setDaemon(flag);
        userThread.start();
        daemonThread.start();

    }
}
//        ThreadPoolExecutor executor=new ThreadPoolExecutor(5, 10,
//                200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
//        Thread u=new Thread(new UserThread());
//        Thread d=new Thread(new DaemonThread());
//        d.setDaemon(true);
//        executor.execute(u);
//        executor.execute(d);
//    }
//}
//class UserThread implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.currentThread().setName("用户线程"+i);
//
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在运行，num=" + i);
//        }
//    }
//}
//class DaemonThread implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            try {
//                Thread.currentThread().setName("守护线程"+i);
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "正在运行，num=" + i);
//        }
//    }
//}