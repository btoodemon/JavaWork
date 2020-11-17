package sync;

public class SyncMethodSalesTicketDemoTest {
    public static void main(String[] args) {
        SyncMethodSalesTicketDemo ticketDemo = new SyncMethodSalesTicketDemo(20);
        new Thread(ticketDemo,"黄牛1号").start();
        new Thread(ticketDemo,"黄牛2号").start();
        new Thread(ticketDemo,"黄牛3号").start();
    }

}
