package testdemo.ThreadDemo;

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
        //Thread.sleep(200);
        //flag = false;//停止线程
    }
}
