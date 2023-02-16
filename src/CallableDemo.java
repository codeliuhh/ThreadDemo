import java.util.concurrent.*;

/**
 * @Author: liuhh
 * @Date: 2022/10/10
 */
public class CallableDemo implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {

        Thread.sleep(100);
        for (int i = 0; i < 3; i++) {
            if (i % 3 == 1 )
                return true;
            else
                return false;
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableDemo c1 = new CallableDemo();
        CallableDemo c2 = new CallableDemo();
        CallableDemo c3 = new CallableDemo();

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(c1);
        Future<Boolean> r2 = ser.submit(c2);
        Future<Boolean> r3 = ser.submit(c3);

        //获取执行结果
        System.out.println("执行结果为 r1 = " + r1.get() + " , r2 = " + r2.get() + " , r3 = " + r3.get());

        //关闭服务
        ser.shutdown();

    }
}
