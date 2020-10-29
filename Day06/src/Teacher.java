import java.util.Arrays;

public class Teacher {
    String name;
    String profession;
    String[] course;
    int teachAge;

    public Teacher(String name1,String profession1,String[] course1, int teachAge1){
        name = name1;
        profession = profession1;
        course = course1;
        teachAge = teachAge1;
    }

    public void info(){
        System.out.println("姓名:"+name+"\t专业方向:"+profession+"\n教授的课程:"+Arrays.toString(course)+"\n教龄:"+teachAge);
    }
}
