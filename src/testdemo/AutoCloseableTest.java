package testdemo;

/**
 * TODO
 * @author David
 * @date 2018-09-12 17:23
 * @version 1.o
 */
public class AutoCloseableTest {

    public static void main(String [] args){
        try(ConnectionLock lock = new ConnectionInnerLock()){
            //do something lock
            System.out.println("doing business...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


interface ConnectionLock extends AutoCloseable{

    /**
     * 释放资源
     */
    void unlock();
}

class ConnectionInnerLock implements ConnectionLock{

    /**
     * 释放资源
     */
    @Override
    public void unlock(){

        //do release resource
        System.out.println("release resource ");
    }

    @Override
    public void close() throws Exception {
        this.unlock();
    }
}
