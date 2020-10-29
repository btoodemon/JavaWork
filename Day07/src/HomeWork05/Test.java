package HomeWork05;

import java.util.Scanner;
/*
	作业5：
        	定义一个管理员类：
        	显示管理员信息的方法：返回管理员用户名和密码的信息；
        	验证用户密码的方法：传入用户名和密码的参数，返回布尔类型，用户名和密码是否正确。
        	编写一个测试类，创建一个管理员类，初始化设置用户名和密码，控制台接收用户输入的用户名和密码，调用验证的方法，显示是否登录成功。
*/
public class Test {
    public static void main(String[] args) {
        Administrator administrator = new Administrator("admin","123456");

        administrator.showInfo();
        Scanner scanner =new Scanner(System.in);
        boolean isLogIn = administrator.verify(scanner,administrator);
        if(isLogIn){
            System.out.println("登陆成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
