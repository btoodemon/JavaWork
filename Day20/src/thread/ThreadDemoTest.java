package thread;

public class ThreadDemoTest {
    public static void main(String[] args) {
        System.out.println("main开始执行");
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.setName("分身1号");
        threadDemo.start();
        System.out.println("main执行结束");
        new ThreadDemo().start();
    }
}
