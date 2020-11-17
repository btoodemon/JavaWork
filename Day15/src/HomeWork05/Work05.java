package HomeWork05;

public class Work05 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        String str="[";
        for (int i = 0; i < arr.length; i++) {
            if(i!=arr.length-1){
                str += arr[i]+",";
            }else {
                str += arr[i]+"]";
            }

        }
        System.out.println(str);
    }
}
