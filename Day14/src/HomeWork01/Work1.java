package HomeWork01;

public class Work1 {
    public static void main(String[] args) {
        String str = "84645864";
        char[] chars = str.toCharArray();
        int sum = 0;
        for (int i = 0; i <chars.length ; i++) {
            double pow = Math.pow(10, chars.length - i - 1);
            int aChar = chars[i];
            sum+= pow*(aChar-48);
            System.out.println(sum);

        }
    }
}
