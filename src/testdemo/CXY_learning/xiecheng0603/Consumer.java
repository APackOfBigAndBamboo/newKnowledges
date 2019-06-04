package testdemo.CXY_learning.xiecheng0603;

import java.util.Queue;

/**
 * TODO:
 *
 * @author David
 * @version 1.o
 * @date 2019-06-03 10:51
 */
public class Consumer extends Thread {
    private final Queue sharedQueue;

    public Consumer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() == 0) {
                    try {
                        System.out.println("队列空了，等待生产");
                        sharedQueue.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                int number = (int) sharedQueue.poll();
                System.out.println("进行消费 : " + number );
                sharedQueue.notify();
            }

        }

    }
}
