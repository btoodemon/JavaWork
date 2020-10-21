public class stuClass {
    public String name;//学生姓名
    public int age;//学生年龄
    public String interest;//学生兴趣

    public stuPerson stuPerson;

    public stuClass(String name, int age, String interest) {
        this.name = name;
        this.age = age;
        this.interest = interest;
    }

    public String stuDoing() { //学生方法
        name = name + "正在睡觉";


        return name;
    }


}
