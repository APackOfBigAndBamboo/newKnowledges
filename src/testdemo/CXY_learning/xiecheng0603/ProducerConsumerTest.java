package testdemo.CXY_learning.xiecheng0603;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO:
 *
 * @author David
 * @version 1.o
 * @date 2019-06-03 10:50
 */
public class ProducerConsumerTest {
    public

    static void main(String args[]) {

        final Queue<Integer> sharedQueue = new LinkedList();

        Thread producer = new Producer(sharedQueue);

        Thread consumer = new Consumer(sharedQueue);

        producer.start();

        consumer.start();

    }
}
