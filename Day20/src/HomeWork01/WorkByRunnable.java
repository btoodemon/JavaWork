package HomeWork01;

public class WorkByRunnable implements Runnable{
    private int count;

    public WorkByRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count>0) {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            count--;
            try {
                System.out.println(Thread.currentThread().getName() + "睡眠");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
