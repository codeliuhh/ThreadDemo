package sync;

import java.time.Period;

/**
 * @Author: liuhh
 * @Date: 2022/10/13
 */
public class UnsafeAccount {


    public static void main(String[] args) {
        Account account = new Account(150, "老婆本本金");
        Bank person1 = new Bank(account, 50, "person1");
        Bank person2 = new Bank(account, 100, "person2");

        person1.start();
        person2.start();
    }
}


class Account{
    int money;
    String desc;

    public Account(int money, String desc){
        this.money = money;
        this.desc = desc;
    }
}

class Bank extends Thread{

    Account account;

    int drawingMoney;

    int handMoney;

    public Bank(Account account, int drawingMoney, String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if(drawingMoney > account.money){
                System.out.println(Thread.currentThread().getName() + "亲 ，资金不足无法取款！");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money -= drawingMoney;
            handMoney += drawingMoney;

            System.out.println(account.desc + " : " + account.money);

            System.out.println(this.getName() + " , 手里有 ： " + handMoney);
        }
    }
}