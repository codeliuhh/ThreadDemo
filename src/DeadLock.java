/**
 * @Author: liuhh
 * @Date: 2022/10/13
 */
public class DeadLock {
    public static void main(String[] args) {
        Change c1 = new Change(0, "liuhh");
        Change c2 = new Change(1, "liucc");
        c1.start();
        c2.start();
    }
}

class Car{}
class Gun{}

class Change extends Thread{

    static Car car = new Car();
    static Gun gun = new Gun();

    int own;
    String name;

    Change(int own, String name){
        this.own = own;
        this.name = name;
    }
    @Override
    public void run() {

        if(own == 0){
            synchronized (car){
                System.out.println(name + "拥有car!");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (gun){
                System.out.println(name + "拥有gun!");
            }
        }else{
            synchronized (gun){
                System.out.println(name + "拥有gun!");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (car){
                System.out.println(name + "拥有car!");
            }
        }
    }
}