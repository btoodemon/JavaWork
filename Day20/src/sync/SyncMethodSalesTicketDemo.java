package sync;

public class SyncMethodSalesTicketDemo implements Runnable{
    private int count;

    public SyncMethodSalesTicketDemo(int count) {
        this.count = count;
    }


    @Override
    public void run() {
        while (true){
            boolean sales = sales();
            if(!sales){
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized boolean sales(){
        boolean flag = true;
        if(count>0){
            count--;
            System.out.println(Thread.currentThread().getName()+"抢到一张票,剩余"+count);
        }else {
            flag = false;
            System.out.println(Thread.currentThread().getName()+"没票了,遗憾退场");
        }
        return flag;
    }
}
