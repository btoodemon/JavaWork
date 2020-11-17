package deadlock;

public class Test {
    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        new Thread(father).start();
        new Thread(son).start();
    }
}
