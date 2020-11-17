package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo implements Runnable{
    private AtomicInteger count;

    public AtomicDemo(AtomicInteger count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true){
            int i;
            if((i=count.decrementAndGet())>0){
                System.out.println(Thread.currentThread().getName()+"抢到了一张票,剩余:"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                break;
            }
        }
    }
}
