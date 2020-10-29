package HomeWork03;

public class Fish extends Animal{
    public Fish(String name, String color, int age) {
        super(name, color, age);
    }

    public void swim(){
        System.out.println(this.getName()+"在游");
    }
}
