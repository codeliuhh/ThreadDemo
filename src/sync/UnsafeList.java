package sync;

import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liuhh
 * @Date: 2022/10/13
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
