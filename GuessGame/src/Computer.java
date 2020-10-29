
public class Computer {
    int num;
    String name;
    int score;

    public Computer(int num1, String name1, int score1) {
        num = num1;
        name = name1;
        score = score1;

    }

    public int toFist() {
        int i = (int) (Math.random() * 3) + 1;
        return i;
    }


}
