import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        //类1  用户User  属性  名字name   分数score
        //类2  电脑Computer  属性  名字name  分数score
        //类3  拳  Fist  属性  类别type
        System.out.println("游戏载入中.........");
        Game game =new Game();

        String flag;
        Scanner scanner = new Scanner(System.in);
        String name2 = game.initial(scanner);


        while (true) {

            game.scoreAll = game.startGame(name2,scanner);
            System.out.println("是否继续游戏(y/n)");
            flag = scanner.next();
            while ("n".equals(flag)) {
                return;
            }
        }



    }
}
