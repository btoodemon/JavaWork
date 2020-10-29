package test02;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SE extends Employee{
    private String hot;


    public SE(int id, String name, String gender, double salary, String hot) {
        super(id, name, gender, salary);
        this.hot = hot;
    }

}
