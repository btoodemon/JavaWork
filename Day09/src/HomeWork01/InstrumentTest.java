package HomeWork01;

public class InstrumentTest {
    public static void main(String[] args) {
        Piano piano = new Piano("三角钢琴","斯坦威",12);
        Violin violin = new Violin("小提琴","卡西欧",6);
        Player.play(piano);
        Player.play(violin);


    }
}
