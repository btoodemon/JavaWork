package test02;


public class CalSalary {
    private CalSalary(){

    }

    public static void calSal(Employee employee){
        double salary = employee.getSalary();

        if(employee instanceof PM){
            PM pm = (PM) employee;
            salary += pm.getBonus();
        }

        System.out.println("工资:"+salary);
    }



}
