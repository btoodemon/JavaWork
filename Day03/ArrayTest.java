

public class ArrayTest {
    public static void main(String[] args) {
        int[] studentScore = new int[3];

        studentScore[0] = 90;
        studentScore[1] = 100;
        studentScore[2] = 80;

        for (int index = 0, len = studentScore.length; index < len; index++) {
            System.out.println("第" + (index + 1) + "个元素数据" + studentScore[index]);

        }


    }
}
