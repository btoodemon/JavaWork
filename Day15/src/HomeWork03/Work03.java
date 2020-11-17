package HomeWork03;

public class Work03 {
    public static void main(String[] args) {
        String str1 = "afabbgccddh";
        String str2 = "abcdhadbfcg";

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        str1 = sort(chars1);
        str2 = sort(chars2);
        if(str1.equals(str2)){
            System.out.println("相等");
        }
        System.out.println(str1);
        System.out.println(str2);
    }

    public static String sort(char[] chars){
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if(chars[j]<chars[i]){
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
            }

        }
        for (int i = 0; i < chars.length; i++) {
            s += chars[i];
        }
        return s;
    }
}
