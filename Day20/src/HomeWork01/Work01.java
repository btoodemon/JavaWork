package HomeWork01;

public class Work01 {
    public static void main(String[] args) {
//        threadRun();
        runnableRun();
    }
    public static void threadRun(){
        WorkByThread workByThread = new WorkByThread(5);
        WorkByThread workByThread1 = new WorkByThread(5);
        workByThread.setName("Thread方法1号");
        workByThread.start();
        workByThread1.setName("Thread方法2号");
        workByThread1.start();
    }

    public static void runnableRun(){
        WorkByRunnable workByRunnable =new WorkByRunnable(5);
        WorkByRunnable workByRunnable1 = new WorkByRunnable(5);
        Thread thread = new Thread(workByRunnable);
        thread.setName("Runnable方法1号");
        Thread thread1 = new Thread(workByRunnable1);
        thread1.setName("Runnable方法2号");
        thread.start();
        thread1.start();
    }
}
