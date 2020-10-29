package HomeWork01;

public class SalaryCalc {

    public void pay(SE se){
        System.out.println(se.getName()+"应发工资:"+se.getSalary());
    }

    public void pay(PM pm){
        System.out.println(pm.getName()+"应发工资:"+(pm.getSalary()+pm.getBonus()));
    }


}
