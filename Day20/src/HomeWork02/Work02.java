package HomeWork02;

public class Work02 {
    public static void main(String[] args) {
        StringPool stringPool = new StringPool();
        Consumer consumer = new Consumer(stringPool);
        Producer producer = new Producer(stringPool);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
