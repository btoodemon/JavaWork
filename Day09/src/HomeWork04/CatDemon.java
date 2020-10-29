package HomeWork04;

public class CatDemon extends Monster{

    public CatDemon(String name, int blood, int aTK, int dEF) {
        super(name, blood, aTK, dEF);
    }

    @Override
    public void attack() {
        System.out.println(this.getName()+"使用爪子攻击");
    }

    @Override
    public void move() {
        System.out.println(this.getName()+"跳着移动");
    }
}
