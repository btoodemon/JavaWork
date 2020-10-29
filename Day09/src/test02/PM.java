package test02;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PM extends Employee{
    private double exp;
    private double bonus;

    public PM(int id, String name, String gender, double salary, int exp, double bonus) {
        super(id, name, gender, salary);
        this.exp = exp;
        this.bonus = bonus;
    }
}
