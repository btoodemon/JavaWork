package HomeWork03;

public class Snake extends Animal{
    public Snake(String name, String color, int age) {
        super(name, color, age);
    }

    public void crawl(){
        System.out.println(this.getName()+"在爬行");
    }
}
