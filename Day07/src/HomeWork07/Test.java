package HomeWork07;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        Player player = new Player();
        System.out.println(player.getName());
        Music music = player.info(scanner);
        player.play(music);




    }
}
