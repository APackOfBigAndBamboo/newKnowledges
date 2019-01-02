package testdemo.ThreadDemo;


/**
 * @Derscription 经典多线程试题，加减法运算，四个线程对某个数字进行交叉运算
 * @auther David
 * @date 2018-09-03 16:20
 * @Version 1.o
 */
public class jiajianfaDemo {
    public static void main(String[] args) {
        Resource re = new Resource();
        SubThread sub = new SubThread(re);
        AddThread add = new AddThread(re);
        new Thread(add, "加法线程a").start();
        new Thread(add, "加法线程b").start();
        new Thread(sub, "减法线程c").start();
        new Thread(sub, "减法线程d").start();

    }
}

class AddThread implements Runnable {
    private Resource resource;

    public AddThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.add();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class SubThread implements Runnable {
    private Resource resource;

    public SubThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resource.sub();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {
    private int num = 0;
    private boolean flag = true;

    public synchronized void add() throws Exception {
        if (this.flag == false) {
            super.wait();
        }
        Thread.sleep(100);
        this.num++;
        System.out.println(Thread.currentThread().getName() + this.num);
        this.flag = false;
        super.notifyAll();
    }

    public synchronized void sub() throws Exception {
        if (this.flag == true) {
            super.wait();
        }
        Thread.sleep(200);
        this.num--;
        System.out.println(Thread.currentThread().getName() + this.num);
        this.flag = true;
        super.notifyAll();
    }
}