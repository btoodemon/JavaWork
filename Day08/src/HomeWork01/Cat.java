package HomeWork01;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cat extends Pet{

    private String JacketStyle;

    public Cat(String name, String gender, double experience, int level, String jacketStyle) {
        super(name, gender, experience, level);
        this.JacketStyle = jacketStyle;
    }

    public void fly(){
        System.out.println(this.getName()+"飞行");
    }



}
