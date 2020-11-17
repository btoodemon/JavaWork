package sync;

public class SalesTicketDemo implements Runnable{
    private int count;

    public SalesTicketDemo(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            synchronized ("a"){
                if (count>0){
                    count--;
                    System.out.println(Thread.currentThread().getName()+"抢到一张票,还剩"+count);
                }else {
                    System.out.println(Thread.currentThread().getName()+"没票了!");
                    break;
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
