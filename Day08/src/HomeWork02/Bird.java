package HomeWork02;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bird extends Animal{

    private String color;

    public Bird(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public void fly(){

        System.out.println(this.getName()+"在飞");
    }
}
