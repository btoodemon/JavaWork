package other;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SalaryCalc {

    public void pay(SE se){

        System.out.println(se.name+"应发工资:"+se.salary);
    }

    public void pay(PM pm){
        System.out.println(pm.name+"应发工资:"+(pm.salary+pm.getBonus()));

    }


}
