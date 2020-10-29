package Test;

import Test.Computer;

public class Student {
    String name;
    int id;
    char sex;

    public Student(String name1,int id1, char sex1){
        name = name1;
        id = id1;
        sex = sex1;
    }

    Computer computer1 = new Computer("AMD3960","H3C","GTX3090","华硕声卡","三星2T");

    public void eat(){
        System.out.println("学生"+name+"在吃饭");
    }

    public void learn(){
        System.out.println("学生"+name+"在学习");
    }


}
