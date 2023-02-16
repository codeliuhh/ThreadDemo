/**
 * @Author: liuhh
 * @Date: 2022/10/18
 */
//生产者-消费者问题，信号灯法
public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}


class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i% 5 == 0){
                tv.play("广告时间！");
            }else{
                tv.play("唐朝诡事录！");
            }
        }
    }
}

class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

class TV{

    String voice;

    boolean flag = true;
    //生产者生产节目
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了: " + voice);
        //生产并通知消费者
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    //消费者消费节目
    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了 " + voice);
        //消费完通知生产者
        this.notifyAll();
        this.flag = !this.flag;
    }
}