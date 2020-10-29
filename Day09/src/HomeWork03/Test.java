package HomeWork03;

public class Test {
    public static void main(String[] args) {
        Snake snake = new Snake("莽山烙铁头蛇","黑色",12);
        Fish fish = new Fish("鲤鱼","红白相间",3);

        Behavior.move(snake);
        Behavior.move(fish);
    }



}
