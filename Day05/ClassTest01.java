public class ClassTest01 {
    public static void main(String[] args) {
        stuClass stu1 = new stuClass("小万", 23, "吃");
        stu1.stuPerson = new stuPerson(10086, "班长");

        System.out.println("学生: " + stu1.name);
        System.out.println("年龄: " + stu1.age);
        System.out.println("兴趣: " + stu1.interest);
        System.out.println("学号: " + stu1.stuPerson.sid);
        System.out.println("职位: " + stu1.stuPerson.sName);
        System.out.println(stu1.stuDoing());
    }
}


