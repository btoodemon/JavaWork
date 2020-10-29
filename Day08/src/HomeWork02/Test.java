package HomeWork02;

public class Test {
    public static void main(String[] args) {
        Bird bird = new Bird("喜鹊",4,"红配绿");
        System.out.println("一只"+bird.getAge()+"岁的"+bird.getColor()+"的"+bird.getName());
        bird.move();
        bird.fly();
    }




}
