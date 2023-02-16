package sync;

/**
 * @Author: liuhh
 * @Date: 2022/10/13
 */
public class UnsafeByTickets {
    public static void main(String[] args) {
        ByTickets byTickets = new ByTickets();
        new Thread(byTickets, "liuhh").start();
        new Thread(byTickets, "liucc").start();
        new Thread(byTickets, "liuxx").start();
    }
}

class ByTickets implements Runnable{
    int total = 10;
    boolean flag = true;

    @Override
    public void run() {
        while(flag){
            buy();
        }
    }

    private synchronized void buy(){
        if(total <= 0){
            flag = false;
            return;
        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + " ， 拿到了第 " + total-- + "票");
    }

}