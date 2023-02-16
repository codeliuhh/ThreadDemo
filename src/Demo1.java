import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @Author: liuhh
 * @Date: 2022/10/10
 */

public class Demo1 implements Runnable{

    private static String winner;

    @Override
    public void run() {

        for (int i = 1; i < 101; i++) {

            if(Thread.currentThread().getName().equals("liuhh") && i % 10 == 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

           if(moreLove(i)){
               System.out.println(Thread.currentThread().getName() + "-----> 走了第 " + i + "步");
               break;
           }
            System.out.println(Thread.currentThread().getName() + "-----> 走了第 " + i + "步");
        }
    }


    private boolean moreLove(int steps){
        if(winner != null){
            return true;
        }
        if(steps >= 100){
           winner = Thread.currentThread().getName();
           System.out.println("winner is " + winner);
           return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();

        new Thread(demo1, "liucc").start();
        new Thread(demo1, "liuhh").start();
    }


}
