import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 阶段1：练习——实现菜单的输出显示
 * 需求说明
 * •输出菜单
 * •选择菜单编号，输出菜单信息
 * •如果编号选择错误，输出“您的输入有误！”
 * <p>
 * 阶段2：练习——实现循环执行功能
 * 需求说明
 * 系统询问用户是否继续
 * 如果用户选择继续，则可以继
 * 续选择菜单，否则程序结束，
 * 退出系统
 * <p>
 * 阶段3：练习——实现注册功能
 * 需求说明
 * 输入用户名和密码，系统产生
 * 4位随机数作为卡号。
 * 注册成功，显示注册信息并修
 * 改注册标识为true
 * <p>
 * 阶段4：练习——实现登录功能
 * 需求说明
 * 输入注册时的用户名和密码，
 * 登录成功，系统提示欢迎信息
 * 如果用户名和密码输入错误，
 * 提示用户继续输入，最多有3
 * 次输入机会
 * <p>
 * 阶段5：练习——实现幸运抽奖功能
 * 需求说明
 * 登录成功后，用户选择幸运抽
 * 奖菜单，进入幸运抽奖功能
 * 输入会员卡号，系统生成5个4
 * 位随机数作为幸运数字
 * 如果会员卡号是其中之一，则
 * 成为本日幸运会员；否则不是
 * 幸运会员
 */
//1.菜单接收输入编号
//
public class LuckyDraw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuInput;
        boolean isSignIn = false;//是否注册
        boolean isLogIn = false;//是否登录
        String[] memberN = new String[3];//声明会员数组
        while (true) {
            System.out.println("----" + "欢迎进入奖客富翁系统----");
            System.out.println("\t\t" + "1. 注册");
            System.out.println("\t\t" + "2. 登录");
            System.out.println("\t\t" + "3. 抽奖");
            System.out.println("\t\t" + "4. 退出");
            System.out.print("请选择菜单:");
            menuInput = scanner.nextInt();
            if (menuInput == 1) {//注册
                if (isLogIn) {//判断是否登录
                    System.out.println("您已登录");
                } else {
                    memberN = signIn();
                    isSignIn = true;//是否注册 isSignIn 变化为是
                }
            } else if (menuInput == 2) {//登录
                if (isSignIn == false) {//判断是否注册
                    System.out.println("您还未注册");
                } else {
                    isLogIn = logIn(memberN);
                }
            } else if (menuInput == 3) {//抽奖
                if (isSignIn) {//判断是否登录
                    boolean con = luckyMember(memberN);
                    if (con == false) { //
                        return;
                    }
                } else {
                    System.out.println("您还未注册或登录");
                }
            } else if (menuInput == 4) {
                return;
            } else {
                System.out.println("您的输入有误！");
            }
        }
    }

    //注册模块
    public static String[] signIn() {//是否注册过  是否继续注册
        String[] messageMember = new String[3];
        Scanner scanner = new Scanner(System.in);
        System.out.println("[[[[[>注册<]]]]]");
        System.out.println("请填写个人注册信息");
        System.out.print("用户名:");
        messageMember[0] = scanner.next();
        System.out.print("密  码:");
        messageMember[1] = scanner.next();
        messageMember[2] = (int) (Math.random() * 9000) + 1000 + "";
        System.out.println("会员卡号" + "\t 用户名" + "\t 密  码");
        System.out.println(messageMember[2] + "\t " + messageMember[0] + "\t " + messageMember[1]);
        return messageMember;
    }

    //登录模块
    public static boolean logIn(String[] judMember) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = new String[2];
        System.out.println(Arrays.toString(judMember));
        System.out.println("[[[[[>登录<]]]]]");
        for (int i = 0; i < 3; i++) {
            System.out.print("用户名:");
            arr[0] = scanner.next();
            if (judMember[0].equals(arr[0])) {
                System.out.print("密  码:");
                arr[1] = scanner.next();

                if (judMember[1].equals(arr[1])) {

                    System.out.println("欢迎您" + arr[0]);
                    return true;
                }
            } else {
                System.out.println("用户不存在");
            }
        }
        System.out.println("密码错误次数达到上限");
        return false;

    }

    //抽奖模块
    public static boolean luckyMember(String[] arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("[[[[[>注册<]]]]]");
        System.out.println("请输入会员号");
        int cardId = scanner.nextInt();
        boolean isLucky = false;
        if (arr[2].equals(cardId + "")) {
            int[] num = new int[5];
            System.out.print("幸运号码是:");
            for (int i = 0; i < 5; i++) {
                num[i] = (int) (Math.random() * 9000) + 1000;
                System.out.print(num[i] + "  ");
                if (cardId == num[i]) {
                    isLucky = true;
                }
            }
            if (isLucky) {
                System.out.println("您是幸运的会员");
            } else {
                System.out.println("您不是幸运会员");
            }
            return isLucky;
        } else {
            System.out.println("您输入的卡号不存在");
            return false;
        }
    }
}
