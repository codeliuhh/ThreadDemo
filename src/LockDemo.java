import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: liuhh
 * @Date: 2022/10/17
 */
public class LockDemo {

    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        new Thread(tickets).start();
        new Thread(tickets).start();
        new Thread(tickets).start();
    }
}

class Tickets implements Runnable{

    int num = 10;

    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        while (true){
            try {
                lock.lock();
                if(num > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num--);
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}