package HomeWork04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class Monster {
    private String name;//名
    private int blood;//血
    private int aTK;//攻击力
    private int dEF;//防御


    public abstract void attack();
    public abstract void move();
}
