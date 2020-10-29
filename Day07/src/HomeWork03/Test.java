package HomeWork03;

/*	作业3
        	定义一个人类，id ，name , age 三个属性， 还具备一个自己与他人比较年龄的方法。
        	类中有属性，可以统计创建人类对象的次数*/
public class Test {
    public static void main(String[] args) {
        Human h1 = new Human(01, "亚当", 23);
        Human h2 = new Human(02, "夏娃", 20);
        Human h3 = new Human(03, "黄帝", 12);
        Human h4 = new Human(04, "炎帝", 44);

        Human.compare(h1, h2);
        Human.compare(h3, h4);

        System.out.println(Human.count);
    }
}
