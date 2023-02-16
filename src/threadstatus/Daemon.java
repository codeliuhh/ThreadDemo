package threadstatus;

import sun.awt.windows.ThemeReader;

/**
 * @Author: liuhh
 * @Date: 2022/10/13
 */
public class Daemon {
    public static void main(String[] args) {

        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认false，为用户线程，设置为true即为守护线程
        thread.start();

        new Thread(new Person()).start();

    }


}


class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("----神与你同在----");
        }
    }
}

class Person implements Runnable{


    @Override
    public void run() {
        for (int i = 1; i < 99; i++){
            System.out.println("---岁月---" + i);
        }
        System.out.println("---goodbye， world!---");
    }
}