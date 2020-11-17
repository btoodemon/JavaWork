package HomeWork11;


public class Work11 {
    public static void main(String[] args) {
        String str = "hello.java,a.txt,x1.jpg,t1.ppt,m.jpg";
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].endsWith("jpg")){
                System.out.println(arr[i]);
            }
        }
    }


}
