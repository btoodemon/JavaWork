package HomeWork01;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class PM {
    private int id;
    private String name;
    private char gender;
    private double salary;
    private int exp;
    private double bonus;

    public PM() {
        id = 501;
        name = "马云";
        gender = '男';
        salary = 1000000.0;
        exp = 17;
        bonus = 320000.0;
    }



    public void show(){
        System.out.println("员工编号:"+id+"\t姓名:"+name+"\t性别:"+gender
                +"\t工资:"+salary+"\t项目经验:"+exp+"\t项目分红:"+bonus);

    }

}
