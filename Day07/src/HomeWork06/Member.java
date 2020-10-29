package HomeWork06;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class Member {
    private int number;
    private String name;
    private int score;

    public Member() {
    }
    //输入会员号
    public int input(Scanner scanner){
        System.out.println("请输入会员号:(4位整数)");
        int inputNumber = scanner.nextInt();
        return inputNumber;
    }
    //判断会员号
    public boolean verify(int num){
        if(num>1000 && num<10000){
            return true;
        }else {
            return false;
        }
    }
    //输入姓名 积分
    public void inputCon(Scanner scanner,int s){
        System.out.println("请输入会员姓名:");
        String inputName = scanner.next();
        System.out.println("请输入会员积分");
        int inputScore = scanner.nextInt();
        this.number =s;
        this.name =inputName;
        this.score =inputScore;
        System.out.println(this.name+"的积分为"+this.score);
    }
    //抽奖
    public void lottery(int number){
        int a =random();
        if(number==a){
            System.out.println("今日幸运数字"+a+",   您是今日幸运用户,享受全场"+(int)(Math.random()*8+1)+"折");
        }else {
            System.out.println("今日幸运数字"+a+",   很遗憾,腿打折");
        }
    }
    //随机4位数
    public int random(){
        int a=0;
        while (a<=1000) {
            a = (int) (Math.random() * 10000);
        }
        return a;
    }

}
