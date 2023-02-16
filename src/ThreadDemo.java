/**
 * @Author: liuhh
 * @Date: 2022/10/10
 */

//继承thread类，重写run方法，调动start方法启动：线程开启不一定会立即执行，具体由CPU调度

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("----多线程----" + i);
        }
    }

    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();


        for (int i = 0; i < 100; i++) {
            System.out.println("----测试主线程----" + i);
        }
    }
}
