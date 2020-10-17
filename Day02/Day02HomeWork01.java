import java.util.Scanner;

public class Day02HomeWork01 {
    public static void main(String[] args) {
        /*
        	需求说明：录入会员信息（会员号、会员生日、会员积分）并显示录入信息
        	升级功能：
        	判断录入是否合法（会员号必为4位整数），
        	录入合法，显示录入的信息；
        	不合法，显示“录入失败”
        */
        System.out.println("题1----------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入会员号(四位整数)");
        int memberN = scanner.nextInt();
        if (memberN < 1000 || memberN > 9999) {
            System.out.println("录入失败");
        } else {

            System.out.println("请输入会员生日(x月x日)");
            scanner.nextLine();// 解决无输入问题
            String memberBD = scanner.nextLine();
            System.out.println("请输入会员积分");
            int memberPo = scanner.nextInt();
            System.out.println("会员号:" + memberN + "\n"
                    + "会员生日" + memberBD + "\n"
                    + "会员积分" + memberPo);
        }




        /*
        	商场实行新的抽奖规则：会员号的百位数字等于产生的随机数字即为幸运会员。实现：
        	1、从键盘接收4位数会员号
        	2、生成随机数
        	int random = (int) (Math.random() * 10);
        	3、算出会员号中在百位的数字号码
        	int baiwei = custNo / 100 % 10;
        	3、使用if-else实现幸运抽奖
        */
        System.out.println("题2----------------------------");
        System.out.println("请输入4位数会员号");
        int memberN2 = scanner.nextInt();
        int random = (int)(Math.random() * 10);
        int numBai = memberN2 / 100 % 10;
        System.out.println("幸运数字" + random);
        if(numBai == random){
            System.out.println("幸运会员");
        }else {
            System.out.println("谢谢参与");
        }

        /*
        	会员根据积分享受不同折扣，如下表。使用多重if结构计算会员折扣
            会员积分x               折扣
            x<2000                  9折
            2000<= x <4000          8折
            4000<= x <8000          7折
            x>=8000                 6折
        */
        System.out.println("题3----------------------------");
        System.out.println("请输入会员积分");
        int memberPo2 = scanner.nextInt();
        if(memberPo2<2000){
            System.out.println("9折");
        }else if (memberPo2<4000){
            System.out.println("8折");
        }else if (memberPo2<8000){
            System.out.println("7折");
        }else {
            System.out.println("6折");
        }


    }


}

