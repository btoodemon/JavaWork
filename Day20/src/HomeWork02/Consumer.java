package HomeWork02;

public class Consumer implements Runnable{
    private StringPool stringPool;

    public Consumer(StringPool stringPool) {
        this.stringPool = stringPool;
    }

    @Override
    public void run() {
        while (true){
            stringPool.consumerString();
        }
    }
}
