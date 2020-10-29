public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("大石",23,new String[]{"数据结构","线性代数"},new String[]{"唱","跳","RAP"});
        student1.info();

        Teacher teacher1 = new Teacher("孔子","文学",new String[]{"论语"},2000);
        teacher1.info();

        Teacher teacher2 = new Teacher("孟子","哲学",new String[]{"课1","课2","课3"},2000);
        teacher2.info();
    }

}
