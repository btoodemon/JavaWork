package HomeWork01;


import java.util.Scanner;

public class Work01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            work01(scanner);
        }catch (EmailException e){
            System.out.println(e.getMessage());
        }

    }

    public static void work01 (Scanner scanner) throws EmailException{

        String emailRegex = "^(\\w{1,})@(qq|sina|163|gmail|126)\\.(com|cn)$";
        String emailRegexSina = "^(\\w{1,})@sina\\.(com|cn)$";
        System.out.println("请输入邮箱:");
        String s = scanner.nextLine();
        if(!s.matches(emailRegex)){
            throw new EmailException("邮箱不合法");
        }else if(s.matches(emailRegexSina)){
            throw new EmailException("是新浪邮箱");
        }else {
            throw new EmailException("不是新浪邮箱");
        }

    }
}
