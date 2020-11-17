package HomeWork02;

public class Producer implements Runnable{
    private StringPool stringPool;

    public Producer(StringPool stringPool) {
        this.stringPool = stringPool;
    }

    @Override
    public void run() {
        while (true){
            stringPool.producerString();
        }
    }
}
