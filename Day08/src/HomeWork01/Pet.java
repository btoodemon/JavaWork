package HomeWork01;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pet {
    private String name;
    private String gender;
    private double experience;
    private int level;

    public Pet(String name, String gender, double experience, int level) {
        this.name = name;
        this.gender = gender;
        this.experience = experience;
        this.level = level;
    }

    public void follow(){
        System.out.println(this.name+"跟随主人");
    }

    public void eat(){
        System.out.println(this.name+"吃食物");

    }

    public void showInfo(){
        System.out.println("宠物名称"+this.getName()+"\t性别:"+this.getGender()+"\t经验:"+this.experience+"\t等级:"+this.getLevel());
    }
}
