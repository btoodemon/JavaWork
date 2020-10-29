package HomeWork04;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Monster[] monster = new Monster[6];
        System.out.println(Arrays.toString(monster));
        monster[0] = new Goblin("胆小的哥布林", 100, 25, 5, 1);
        monster[1] = new Goblin("强壮的哥布林", 300, 70, 25, 2);
        monster[2] = new Goblin("愤怒的哥布林", 200, 120, 40, 5);
        monster[3] = new CatDemon("一尾猫妖",80,40,10);
        monster[4] = new CatDemon("三尾猫妖",230,180,30);
        monster[5] = new CatDemon("九尾猫妖",550,260,60);

        for (int i = 0; i < monster.length; i++) {
            monster[i].attack();
            monster[i].move();
        }
    }
}
