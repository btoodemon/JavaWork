package deadlock;

public class Son implements Runnable{
    @Override
    public void run() {
        synchronized ("son"){
            System.out.println("儿子有成绩单");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ("father"){
                System.out.println("儿子想要零花钱");
            }
        }
    }
}
