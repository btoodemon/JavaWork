package deadlock;

public class Father implements Runnable{
    @Override
    public void run() {
        synchronized ("father"){
            System.out.println("父亲有零花钱");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized ("son"){
                System.out.println("父亲想要成绩单");
            }
        }
    }
}
