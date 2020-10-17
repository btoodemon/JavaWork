import java.util.Arrays;

public class ArrayTest1 {
    public static void main(String[] args) {

        //有一列乱序的字符，‘a’,‘c’,‘u’,‘b’,‘e’,‘p’,‘f’,‘z’，排序并按照英文字母表的逆序输出

        char[] num1 = {'a','c','u','b','e','p','f','z'} ;



//        for (int i = 200; i > 0; i--) {
//            for (int j = 0; j <num1.length; j++) {
//                if(i==num1[j]){
//                    System.out.print(num1[j] + " ");
//
//                }
//            }
//
//        }

        for (int i = 0; i < num1.length-1; i++) {
            for (int j = 0; j < num1.length-i-1; j++) {
                if(num1[j]<num1[j+1]){
                    char temp = num1[j];
                    num1[j] = num1[j+1];
                    num1[j+1] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(num1));


    }
}
