package HomeWork01;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class SE {
    private int id;
    private String name;
    private char gender;
    private double salary;
    private String hot;

    public SE() {
        id = 101;
        name = "雷军";
        gender = '男';
        salary = 500000.0;
        hot = "超高";
    }



    public void show(){
        System.out.println("员工编号:"+id+"\t姓名:"+name+"\t性别:"+gender
                +"\t工资:"+salary+"\t关注度:"+hot);

    }


}
