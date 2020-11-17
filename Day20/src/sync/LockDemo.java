package sync;

import java.util.concurrent.locks.Lock;

public class LockDemo implements Runnable {
    private int count;
    private Lock lock;

    public LockDemo(int count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (count>0) {
                    count--;
                    System.out.println(Thread.currentThread().getName()+"抢到一张票,还剩:"+count);
                    Thread.sleep(500);
                } else {
                    System.out.println(Thread.currentThread().getName()+"没票了,遗憾退场");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
