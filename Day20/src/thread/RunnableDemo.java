package thread;

public class RunnableDemo implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+",开始执行");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+",执行结束");
    }
}
