package HomeWork12;

public class Work12 {
    public static void main(String[] args) {
        String str = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
        str = str.replaceAll("\\.", "");
        System.out.println(str);
        str = str.replaceAll("(.)\\1+", "$1");//?什么玩意

        System.out.println(str);
    }
}
