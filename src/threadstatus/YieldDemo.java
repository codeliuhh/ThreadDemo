package threadstatus;

/**
 * @Author: liuhh
 * @Date: 2022/10/13
 */
public class YieldDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("vip 通道 --- " + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        YieldDemo yieldDemo = new YieldDemo();
        Thread thread = new Thread(yieldDemo);
        thread.start();

        for (int i = 0; i < 20; i++) {
            if( i == 9){
                thread.join();
            }
            System.out.println("main --- " + i);
        }
    }
}
