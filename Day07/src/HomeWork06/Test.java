package HomeWork06;

import java.util.Scanner;

/*
	作业6：
        	编写会员类：
        	编写测试类：
        	接收控制台用户输入会员号、会员姓名、积分，创建一个会员对象，验证会员号是否合法，不合法提示退出，合法保存会员数据，同时显示当前用户的(积分)折扣信息，最后进行抽奖，提示是否是(会员号)幸运用户。
*/
public class Test {
    public static void main(String[] args) {
        Member member1 = new Member();
        Scanner scanner = new Scanner(System.in);
        int s = member1.input(scanner);

        if(member1.verify(s)){
            member1.inputCon(scanner,s);
            member1.lottery(member1.getNumber());
        }else {
            System.out.println("您输入的会员号不正确!");
        }
        //测试是否存入 System.out.println(member1.getNumber()+" "+member1.getName()+" "+member1.getScore());







    }

}
