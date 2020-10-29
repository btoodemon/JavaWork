package HomeWork04;

public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name, String color) {
        super(name, color);
    }

    public void bite(){
        System.out.println("一条"+this.getColor()+"色的"+this.getName()+"咬了你一口,并嘱托你记得打疫苗.");
    }
}
