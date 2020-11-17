package thread;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.currentThread().sleep(1500);
        System.out.println(Thread.currentThread().getName()+"执行结束");
        return "这是返回结果!";
    }
}
