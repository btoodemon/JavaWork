public class Fist {
    String[] type;


    public Fist() {
        type = new String[]{"剪刀", "石头", "布"};
    }

    public int showFist(int u, int c) {
        int i;
        System.out.println("电脑出拳: [" + type[u - 1] + "\t]");
        System.out.println("你的出拳: [" + type[c - 1] + "\t]");
        if (u - c == 0) {
            System.out.println("结果:和局");
            i = 0;
        } else if (u - c == -1 || u - c == 2) {
            System.out.println("结果:电脑赢");
            i = -1;
        } else {
            System.out.println("结果:你赢了");
            i = 1;
        }
        return i;
    }

}
