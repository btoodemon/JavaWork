package HomeWork01;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Piano extends Instrument{
    private String music;

    public Piano(String name, String sign, int year) {
        super(name, sign, year);
        music = "出埃及记";
    }
}
