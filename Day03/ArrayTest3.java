public class ArrayTest3 {
    public static void main(String[] args) {
        /*
        	李雷要去买一部手机，他询问了4家店的价格，
        分别是2899元，2950元，2850元和3100元，显示输出最低价
        */

        int[] arr3 = {2899,2950,2850,3100};
        int min =arr3[0];

//        for (int i = 0; i < arr3.length; i++) {
//            if(min>arr3[i]){
//                min = arr3[i];
//            }
//        }
        for(int num : arr3){
            if(min>num){
               min = num;
           }

        }
        System.out.println("最低价"+min);


    }
}
