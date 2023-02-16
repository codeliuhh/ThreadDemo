package threadstatus;

/**
 * @Author: liuhh
 * @Date: 2022/10/11
 */
//不建议使用JDK自带的stop或者destroy方法
    //利用次数
    //标识位
public class StopDemo implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run -- " + i++);
        }
    }

    public static void main(String[] args) {
        StopDemo demo = new StopDemo();
        new Thread(demo).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main -- " + i);
            if(i == 900 ){
                demo.stop();
                System.out.println("---> stop");
            }
        }
    }

    public void stop() {
        this.flag = false;
    }
}
