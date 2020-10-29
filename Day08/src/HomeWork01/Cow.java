package HomeWork01;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cow extends Pet {
    private String hornStyle;

    public Cow(String name, String gender, double experience, int level, String hornStyle) {
        super(name, gender, experience, level);
        this.hornStyle = hornStyle;
    }

    public void pick(){
        System.out.println(this.getName()+"捡道具");
    }
}
