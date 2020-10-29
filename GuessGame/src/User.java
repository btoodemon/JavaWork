import java.util.Scanner;

public class User {
    String name;
    int score;

    public User(String name1) {
        name = name1;
        score = 0;
    }

    public int toFist(Scanner scanner) {
        while (true) {
            System.out.println("请出拳: 1.剪刀 2.石头 3.布");
            String i = scanner.next();
            if ("1".equals(i) || "2".equals(i) | "3".equals(i)) {
                return Integer.valueOf(i).intValue();
            } else {
                System.out.println("输入有误,请重新输入");
            }
        }
    }


}
