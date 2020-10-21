import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("录入班级数:");
        int roomNum = input.nextInt();
        double[][] score = new double[roomNum][];
        for (int i = 0; i < roomNum; i++) {
            System.out.println("请录入" + (i + 1) + "个班级的学生数:");
            int studentNum = input.nextInt();
            score[i] = new double[studentNum];
            for (int j = 0; j < studentNum; j++) {
                System.out.println("请录入第" + (i + 1) + "个班级第" + (j + 1) + "个学生的成绩");
                double studentScore = input.nextDouble();
                score[i][j] = studentScore;
            }
        }

        int count1 = 1;
        for (double[] dou : score) {
            int count2 = 1;
            for (double sc : dou) {
                System.out.println("第" + count1 + "个班级第" + count2 + "个学生的成绩:" + sc);
                count2++;
            }
            count1++;
        }
        int index = 0;
        for (double[] dou : score) {
            System.out.println(Arrays.toString(score[index]));
            index++;
        }


    }
}
