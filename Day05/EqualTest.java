import java.util.Arrays;

public class EqualTest {
    public static void main(String[] args) {
        int i = 1;
        double d = 11.11;
        String s = "string";
        int[] iarr = {3,5,2,8,1};
        int[][] iarr2 = {{8,11},{2,4}};
        String[] sarr = {"sd", "string" };
        String[][] sarr2 = {{"8","11"},{"2","4"}};
        String[][][] sarr3 = {{{"sd","string"},{"8","11"}} , {{"2","3"}}};

        if(Arrays.equals(iarr2,sarr2)){
            System.out.println("相等");
        }else {
            System.out.println("不等");
        }

        //iarr.equals(i);

        //  iarr[4] == i  true
        //  iarr[][]== i  true
        //  (i+"").equals(sarr[4])   true
        //  (iarr[4]+"").equals(sarr[4])  true
        //  (iarr2[0][0]+"").equals(sarr[4])  true
        //  s.equals(sarr[1])  true
        //  sarr2[0][1].equals(sarr[1])  true
        //  Arrays.equals(sarr,sarr2[0])  true
        //  Arrays.deepEquals(sarr2,sarr3[0])  true
        //  sarr2[0][1].equals(sarr3[0][0][1])  true


        //  sarr[4].equals(i)  false
        //  sarr[4] == (i+"")  false
        //
    }
}
