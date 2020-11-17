package produce;

public class Test {
    public static void main(String[] args) {
        OrderPool orderPool = new OrderPool();
        ProduceThread produceThread = new ProduceThread(orderPool);
        ConsumerThread consumerThread = new ConsumerThread(orderPool);
        new Thread(produceThread).start();
        new Thread(consumerThread).start();
    }
}
