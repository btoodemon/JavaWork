import java.util.Scanner;

public class Game {
    int[] scoreAll;

    public Game() {
        scoreAll = new int[4];
    }

    public String initial(Scanner scanner) {
        System.out.println("请输入您的游戏名:");
        String name1 = scanner.next();
        return name1;
    }

    public int[] startGame(String name3, Scanner scanner) {

        Computer computer1 = new Computer(1, "刘备", 0);
        Computer computer2 = new Computer(2, "孙权", 0);
        Computer computer3 = new Computer(3, "曹操", 0);
        Fist fist = new Fist();
        User user = new User(name3);
        user.score = scoreAll[0];
        computer1.score = scoreAll[1];
        computer2.score = scoreAll[2];
        computer3.score = scoreAll[3];
        System.out.println("当前分数情况为:" + user.name + ":" + user.score
                + "\t" + computer1.name + ":" + computer1.score
                + "\t" + computer2.name + ":" + computer2.score
                + "\t" + computer3.name + ":" + computer3.score);
        System.out.println("请输入要对战的电脑:"
                + computer1.num + "." + computer1.name
                + "\t" + computer2.num + "." + computer2.name
                + "\t" + computer3.num + "." + computer3.name);
        int choice = scanner.nextInt();
        String isContinue;
        while (true) {
            int i;
            switch (choice) {
                case 1:
                    i = fist.showFist(computer1.toFist(), user.toFist(scanner));
                    user.score += i;
                    computer1.score -= i;
                    System.out.println(computer1.name + "的分数" + computer1.score);
                    break;
                case 2:
                    i = fist.showFist(computer1.toFist(), user.toFist(scanner));
                    user.score += i;
                    computer2.score -= i;
                    System.out.println(computer2.name + "的分数" + computer2.score);
                    break;
                case 3:
                    i = fist.showFist(computer1.toFist(), user.toFist(scanner));
                    user.score += i;
                    computer3.score -= i;
                    System.out.println(computer3.name + "的分数" + computer3.score);
                    break;
            }
            System.out.println(user.name + "的分数" + user.score);
            System.out.println("是否开始下一轮(y/n)");
            isContinue = scanner.next(); //"y";
            while ("n".equals(isContinue)) {
                scoreAll[0] = user.score;
                scoreAll[1] = computer1.score;
                scoreAll[2] = computer2.score;
                scoreAll[3] = computer3.score;
                return scoreAll;
            }

        }


    }

}
