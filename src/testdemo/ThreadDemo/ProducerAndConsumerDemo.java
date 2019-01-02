package testdemo.ThreadDemo;

/**
 * @Derscription 生产者与消费者多线程Demo 生产一个消费一个生产一个消费一个 并记录生产数量
 * 公司company 生产apple  people吃apple
 * @auther David
 * @date 2018-09-04 16:48
 * @Version 1.o
 */
public class ProducerAndConsumerDemo {
    public static void main(String[] args) {
        Source source=new Source();
        new Thread(new Company(source)).start();
        new Thread(new People(source)).start();
    }

}
class Company implements Runnable{
    private Source source;
    public Company(Source source){
        this.source=source;
    }

    public void run() {

        for (int i=0;i<50;i++){
            try {
                this.source.Producer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class People implements Runnable{
    private Source source;
    public People(Source source){
        this.source=source;
    }

    public void run() {

        for (int i=0;i<50;i++){
            try {
                this.source.Consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Source{
    private Apple apple;
    public synchronized void  Producer() throws Exception{
        if (this.apple!=null){
            super.wait();
        }
        this.apple=new Apple(1,"好吃");
        System.out.println("生产-----"+this.apple);
        super.notifyAll();
    }
    public synchronized void  Consumer() throws Exception{
        if (this.apple==null){
            super.wait();
        }
        System.out.println("取走-----"+this.apple);
        this.apple=null;

        super.notifyAll();
    }

}
class Apple {
    private static int num;
    private int price;
    private String taste;

    public  Apple (int price,String taste) {

        this.price = price;
        this.taste=taste;
        num++;
        System.out.println("生产-----第"+num+"个苹果");
    }

}