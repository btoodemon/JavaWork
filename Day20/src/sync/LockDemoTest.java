package sync;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemoTest {
    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock(true);
        LockDemo lockDemo = new LockDemo(20, reentrantLock);
        new Thread(lockDemo,"黄牛1号").start();
        new Thread(lockDemo,"黄牛2号").start();
        new Thread(lockDemo,"黄牛3号").start();

    }
}
