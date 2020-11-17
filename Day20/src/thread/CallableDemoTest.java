package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemoTest {
    public static void main(String[] args) {
        System.out.println("main开始执行");
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<String> task = new FutureTask<>(callableDemo);
        new Thread(task,"callable分身").start();
        try {
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main执行结束");
    }
}
