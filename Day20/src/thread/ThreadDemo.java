package thread;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+",正在执行~");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+",执行结束~");
    }
}
