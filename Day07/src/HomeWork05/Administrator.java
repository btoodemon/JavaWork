package HomeWork05;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class Administrator {
    private String name;
    private String pass;

    public Administrator(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public void showInfo(){
        System.out.println("用户名:"+name+"\t密码:"+pass);
    }

    public boolean verify(Scanner scanner,Administrator administrator){
        System.out.println("请输入用户名:");
        String input1 = scanner.next();
        System.out.println("请输入密码");
        String input2 = scanner.next();
        if (input1.equals(administrator.name) && input2.equals(administrator.pass)){
            return true;
        }else {
            return false;
        }

    }

}
