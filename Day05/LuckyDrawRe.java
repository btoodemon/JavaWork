import java.util.Scanner;

public class LuckyDrawRe {
    //数组[5] 记录用户数据 + 标识
    //memberInfo[0] 用户名        null-未注册
    //memberInfo[1] 密码
    //memberInfo[2] 会员号
    //memberInfo[3] 是否 登录标识  null-未登录  "1"-已登录  "2"-禁止登录
    //memberInfo[4] 是否 中奖标识  null-未抽奖  "1"-已抽奖  "2"-已抽中奖

    //menu 目录选择
    //register 注册
    //login 登录
    //draw 抽奖
    //random 随机四位号码
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String[] memberInfo = new String[5];
        while (true) {
            choice = menu(scanner);
            switch (choice) {
                case 1://注册
                    memberInfo = register(memberInfo, scanner);
                    break;
                case 2://登录
                    memberInfo[3] = login(memberInfo, scanner);
                    break;
                case 3://抽奖
                    memberInfo[4] = draw(memberInfo, scanner);
                    break;
                case 4://退出
                    return;
                default:
            }
        }

    }
    //目录系统
    public static int menu(Scanner scanner) {
        System.out.println("----" + "欢迎进入奖客富翁系统----");
        System.out.println("\t\t" + "1. 注册");
        System.out.println("\t\t" + "2. 登录");
        System.out.println("\t\t" + "3. 抽奖");
        System.out.println("\t\t" + "4. 退出");
        int menuNum;
        while (true) {
            System.out.print("请选择菜单:");
            menuNum = scanner.nextInt();
            if (menuNum == 1 || menuNum == 2 || menuNum == 3 || menuNum == 4) {
                break;
            } else {
                System.out.println("输入错误请重新输入");
            }
        }
        return menuNum;


    }

    //注册系统
    public static String[] register(String[] info, Scanner scanner) {
        System.out.println("--[注册系统]--");
        System.out.println("请输入注册信息:");
        System.out.print("用户名:");
        info[0] = scanner.next();
        System.out.print("密  码:");
        info[1] = scanner.next();
        info[2] = random();//random
        info[3] = null;//重新注册 会重置 用户 登录标识
        info[4] = null;//重新注册 会重置 用户 中奖标识
        System.out.println("注册成功!");
        System.out.println("用户名" + "\t 密  码" + "\t 会员卡号");
        System.out.println(info[0] + "\t " + info[1] + "\t " + info[2]);
        return info;
    }

    //登录系统
    public static String login(String[] info, Scanner scanner) {
        System.out.println("--[登录系统]--");
        if (info[0] == null) {
            System.out.println("您还未注册,请先注册");
        } else if ("2".equals(info[3])) {
            System.out.println("您已被限制登录");
        } else if ("1".equals(info[3])) {
            System.out.println("您已在登录状态");
        } else {
            int i = 0;
            while (true) {
                System.out.print("请输入用户名:");
                String name = scanner.next();
                System.out.print("请输入密  码:");
                String pass = scanner.next();
                if (name.equals(info[0]) && pass.equals(info[1])) {
                    info[3] = "1";              //登陆成功,标记已登录
                    System.out.println("登陆成功,欢迎" + info[0]);
                    break;
                } else if (i > 1) {
                    System.out.println("错误次数达到上限,用户限制登录");
                    info[3] = "2";              //错误3次,标记限制登录
                    break;
                } else {
                    System.out.println("输入错误,重新输入   剩余" + (2 - i) + "次机会");
                    i++;
                }
            }
        }
        return info[3];

    }

    //抽奖系统
    public static String draw(String[] info, Scanner scanner) {
        System.out.println("--[抽奖系统]--");
        if (info[0] == null) {                  //检测注册
            System.out.println("您还未注册,请注册");
        } else if (info[3]==null) {             //检测登陆
            System.out.println("您还未登录,请登录");
        } else if ("2".equals(info[4])) {       //检测是否已经抽过奖 [中奖]
            System.out.println("您已抽过并中奖!恭喜!");
        } else if ("1".equals(info[4])) {       //[未中奖]
            System.out.println("您已抽过奖,未中奖,很遗憾!");
        } else {                                //进行抽奖
            while (true) {                      //输入会员号,并判断是否与记录一直
                System.out.print("请输入会员号:");
                String num = scanner.next();
                if (num.equals(info[2])) {
                    break;
                } else {
                    System.out.println("输入有误");
                }
            }
            for (int i = 0; i < 5; i++) {       //会员号与5个随机数比较
                String luckN = random();
                if (luckN.equals(info[2])) {    //相等则更改
                    info[4] = "2";              //中奖标识
                }
            }
            if ("2".equals(info[4])) {          //检测中奖标识
                System.out.println("您已中奖");
            } else {
                info[4] = "1";
                System.out.println("很遗憾,您未中奖");
            }
        }
        return info[4];
    }

    //随机四位数
    public static String random() {
        int num;
        while (true) {
            num = (int) (Math.random() * 10000);
            if (num > 1000) {
                break;
            }
        }
        return num + "";
    }
}
