package sync;

public class SalesTicketDemoTest {
    public static void main(String[] args) {
        SalesTicketDemo demo = new SalesTicketDemo(20);
        new Thread(demo,"黃牛1号").start();
        new Thread(demo,"黃牛2号").start();
        new Thread(demo,"黃牛3号").start();

    }
}
