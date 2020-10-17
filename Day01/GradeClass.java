public class GradeClass {
    public static void main(String[] args) {
        int gradeHtml = 89;
        int gradeJava = 90;
        int gradeSql = 60;
        int num_JavaSql = gradeSql - gradeJava;
        double num_JSH = (gradeHtml + gradeJava + gradeSql) / 3;
        System.out.println("Java课和SQL课的分数之差：" + num_JavaSql);
        System.out.println("3门课的平均分" + num_JSH);
    }
}

