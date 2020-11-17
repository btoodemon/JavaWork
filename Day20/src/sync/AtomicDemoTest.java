package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemoTest {
    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo(new AtomicInteger(20));
        new Thread(atomicDemo,"黄牛1号").start();
        new Thread(atomicDemo,"黄牛2号").start();
        new Thread(atomicDemo,"黄牛3号").start();

    }
}
