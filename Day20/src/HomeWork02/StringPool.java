package HomeWork02;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class StringPool {
    CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    public synchronized void producerString(){
        if(list.size() == 100){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add("string");
        System.out.println("生成一个字符串,目前已有:"+list.size());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try {

            Thread.sleep(random.nextInt(500,1500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
    }

    public synchronized void consumerString(){
        if(list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(0);
        System.out.println("处理一个字符串,还剩 : " + list.size());
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try {
            Thread.sleep(random.nextInt(2000,3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();
    }
}
