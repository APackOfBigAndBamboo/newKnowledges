package ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Derscription 模拟抢答场景
 * @auther David
 * @date 2018-09-12 16:07
 * @Version 1.o
 */
public class QiangDaThread {
    public static void main(String[] args) throws Exception {
        Qiang qiang = new Qiang();
        FutureTask<String> result1 = new FutureTask<>(qiang);
        FutureTask<String> result2 = new FutureTask<>(qiang);
        FutureTask<String> result3 = new FutureTask<>(qiang);
        new Thread(result1, "A").start();

        new Thread(result2, "b").start();
        new Thread(result3, "c").start();
        String a = result1.get();
        String b = result2.get();
        String c = result3.get();
        System.out.println(a + b + c);
    }
}

class Qiang implements Callable<String> {
    boolean flag = false;

    @Override
    public String call() throws Exception {
        synchronized (this) {
            if (flag == false) {
                flag = true;
                return Thread.currentThread().getName() + "抢答成功！";
            } else {
                return Thread.currentThread().getName() + "抢答失败！";
            }
        }
    }
}