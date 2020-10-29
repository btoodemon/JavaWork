package HomeWork01;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pig extends Pet{

    private String hairColor;

    public Pig(String name, String gender, double experience, int level, String hairColor) {
        super(name, gender, experience, level);
        this.hairColor = hairColor;
    }

    public void roll(){
        System.out.println(this.getName()+"滚动");
    }

}
