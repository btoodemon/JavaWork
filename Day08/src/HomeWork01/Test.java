package HomeWork01;

public class Test {
    public static void main(String[] args) {
        Pig pig = new Pig("猪猪超人","公",2300,12,"yellow");
        pig.showInfo();
        pig.follow();
        pig.eat();
        pig.roll();


        Cat cat= new Cat("汤姆猫","母",9855,24,"皇帝的新装");
        cat.showInfo();
        cat.follow();
        cat.eat();
        cat.fly();


        Cow cow = new Cow("蒙牛","母",4236,10,"red");
        cow.showInfo();
        cow.follow();
        cow.eat();
        cow.pick();

    }



}
