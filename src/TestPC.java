import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * @Author: liuhh
 * @Date: 2022/10/17
 */
//生产者，消费者模型-->利用缓存区解决--管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}

//生产者
class Productor extends Thread{
    SynContainer synContainer;
    public Productor(SynContainer synContainer){
        this.synContainer = synContainer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了 " + i + " 只鸡！");
        }
    }
}

//消费者
class Consumer extends Thread{
    SynContainer synContainer;

    public Consumer(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了 " + synContainer.pop().id + " 只鸡！");
        }
    }
}

//产品
class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //设置一个容器大小
    Chicken[] chickens = new Chicken[10];
    //计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //缓冲区满不满
        if(count == chickens.length){
            //生产者等待，通知消费者消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //丢入产品
        chickens[count] = chicken;
        count++;
        //通知消费者
        this.notifyAll();
    }

    //消费者消费
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //可消费
        count--;
        Chicken chicken = chickens[count];

        //消费完，通知生产者生产
        this.notifyAll();

        return chicken;


    }
}