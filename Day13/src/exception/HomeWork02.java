package exception;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] commodity = new String[4][];
        commodity[0] = new String[]{"1","二筒方便面","7","5"};
        commodity[1] = new String[]{"2","奥利给饼干","9","3"};
        commodity[2] = new String[]{"3","周黑的小鸭","4","35"};
        commodity[3] = new String[]{"4","东湖的藕粉","2","23"};
        System.out.println("----------------------------------------");
        System.out.println("|           欢迎光顾大大大超市           |");
        System.out.println("----------------------------------------");
        System.out.println("|      商品      |    数量   |   价格    |");
        for (int i = 0; i < commodity.length; i++) {
                System.out.println("|  "+commodity[i][0]+commodity[i][1]+"\t | \t"+commodity[i][2]+"\t\t|\t"+commodity[i][3]+"元\t\t|");
        }
        

        while (true) {
            try {
                System.out.println("请输入要购买的商品编号");
                int name = scanner.nextInt()-1;
                System.out.println("请输入数量");
                int num = scanner.nextInt();

                judge(name, num, commodity);
                break;
            } catch (SimlpeException1 simlpeException1) {
                System.out.println("所选商品不存在");
            } catch (SimlpeException2 simlpeException2) {
                System.out.println("商品数量不足");
            }
        }
        System.out.println("谢谢惠顾");

    }

    public static String[][] judge(int name,int num,String[][] com)throws SimlpeException1,SimlpeException2{

        try {
            String strings = com[name][1];
            int i = Integer.parseInt(com[name][2]) - num;
            if(i<0){
                throw new ArithmeticException();//!!!!!!!写的不好
            }
            System.out.println("成功购买"+strings+" "+num+"件,请支付"+Integer.parseInt(com[name][3])*num+"元");
            com[name][2] = i+"";
        }catch (ArithmeticException e) {
            throw new SimlpeException2("数量不足");
        }catch (Exception e){
            throw new SimlpeException1("名称错误");
        }
        return com;


    }


}
