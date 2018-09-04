package ThreadDemo;


/**
 * @Derscription 生产者消费Demo
 * @auther David
 * @date 2018-09-03 11:23
 * @Version 1.o
 */
public class ThreadDemo {
    public static void main(String[] args) {

        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Consumer implements Runnable {
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.msg.get();
        }
    }
}

class Producer implements Runnable {
    private Message msg;

    public Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            if (x % 2 == 0) {
                this.msg.set("王建", "帅的一批");
            } else {
                this.msg.set("小高", "大丑逼");
            }
        }
    }
}

class Message {
    private String title;
    private String content;
    private boolean flag = true;//为flase时允许set//为true时允许get

    public synchronized void get() {
        if (this.flag == true) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(this.title + "-" + this.content);
        } finally {
            this.flag=true;
            super.notify();
        }
    }

    public synchronized void set(String title, String content) {
        if (this.flag == false) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;
        super.notify();
    }

}