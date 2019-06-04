package testdemo.CXY_learning.xiecheng0603;

import java.util.Queue;

/**
 * TODO:
 *
 * @author David
 * @version 1.o
 * @date 2019-06-03 10:51
 */
public class Producer extends Thread {
    private static final int MAX_QUEUE_SIZE = 5;
    private final Queue sharedQueue;

    public Producer(Queue sharedQueue) {
        super();
        this.sharedQueue = sharedQueue;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (sharedQueue) {
                while (sharedQueue.size() >= MAX_QUEUE_SIZE) {
                    System.out.println("队列满了，等待消费");
                    try {
                        sharedQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sharedQueue.add(i);

                System.out.println("进行生产 : " + i);
                sharedQueue.notify();
            }

        }

    }
}
