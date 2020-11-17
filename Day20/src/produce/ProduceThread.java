package produce;

public class ProduceThread implements Runnable{
    private OrderPool orderPool;

    public ProduceThread(OrderPool orderPool) {
        this.orderPool = orderPool;
    }

    @Override
    public void run() {
        while (true){
            orderPool.produceOrder();
        }
    }
}
