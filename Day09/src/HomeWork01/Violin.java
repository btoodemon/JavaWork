package HomeWork01;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Violin extends Instrument{
    private String music;

    public Violin(String name, String sign, int year) {
        super(name, sign, year);
        music = "月光";
    }
}
