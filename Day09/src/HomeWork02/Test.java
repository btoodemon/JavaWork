package HomeWork02;

public class Test {
    public static void main(String[] args) {
        BMW bmw = new BMW("白色","宝马888",4);
        Benz benz = new Benz("黑色","奔驰A12",6);


        Driver.drive(bmw);
        Driver.drive(benz);
    }
}
