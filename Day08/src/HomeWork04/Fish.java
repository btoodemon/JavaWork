package HomeWork04;

public class Fish extends Animal{

    public Fish() {
    }

    public Fish(String name, String color) {
        super(name, color);
    }

    public void blow(){
        System.out.println("一条"+this.getColor()+"色的"+this.getName()+"向你吐了一堆泡泡,然后在7秒后忘记了.");
    }
}
