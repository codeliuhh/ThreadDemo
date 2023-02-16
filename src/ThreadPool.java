import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liuhh
 * @Date: 2022/10/18
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
