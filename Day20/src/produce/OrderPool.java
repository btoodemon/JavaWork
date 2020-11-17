package produce;

import java.util.concurrent.CopyOnWriteArrayList;

public class OrderPool {
    CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    public synchronized void produceOrder(){
        if (list.size() == 20){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add("order");
        System.out.println("生成一个订单,目前已有:"+list.size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
    }

    public synchronized void consumerOrder(){
        if (list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        System.out.println("消费一个订单,还剩:"+list.size());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
    }
}
