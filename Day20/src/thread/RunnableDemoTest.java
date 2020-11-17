package thread;

public class RunnableDemoTest {
    public static void main(String[] args) {
        System.out.println("main开始执行");
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.setName("分身1号");
        Thread thread2 = new Thread(runnableDemo);
        thread2.setName("分身2号");

        new Thread(runnableDemo,"分身3号").start();

        thread.start();
        thread2.start();
        System.out.println("main方法执行结束");
    }
}
