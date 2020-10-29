import java.util.Arrays;

public class Student {
    String name;
    int age;
    String[] course;
    String[] interest;

    public Student(String name1,int age1,String[] course1, String[] interest1){
        name = name1;
        age = age1;
        course =course1;
        interest = interest1;
    }

    public void info(){
        System.out.println("姓名:"+name+"\t年龄:"+age+"\n参加的课程:"+Arrays.toString(course)+"\n兴趣:"+Arrays.toString(interest));
    }
}
