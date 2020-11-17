package produce;

public class ConsumerThread implements Runnable{
    private OrderPool orderPool;

    public ConsumerThread(OrderPool orderPool) {
        this.orderPool = orderPool;
    }


    @Override
    public void run() {
        while (true){
            orderPool.consumerOrder();
        }
    }
}
