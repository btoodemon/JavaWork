package HomeWork04;

public class Goblin extends Monster{

    private int rage;//狂暴

    public Goblin(String name, int blood, int aTK, int dEF, int rage) {
        super(name, blood, aTK, dEF);
        this.rage = rage;
    }

    @Override
    public void attack() {
        System.out.println(this.getName()+"使用石头进行攻击");
    }

    @Override
    public void move() {
        System.out.println(this.getName()+"缓慢移动");
    }
}
