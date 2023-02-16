package threadstatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liuhh
 * @Date: 2022/10/11
 */
//用于模拟网络延迟，倒计时等
public class SleepDemo {

    public static void tenDown() throws InterruptedException {
        int i = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(i--);
            if(i <= 0){
                break;
            }
        }
    }


    public static void time(){
        Date date = new Date(System.currentTimeMillis());

        while (true){
            try {
                TimeUnit.SECONDS.sleep(1);
//                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public static void main(String[] args) throws InterruptedException {
        time();
    }
}
