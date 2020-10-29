package HomeWork02;

/*
	作业2:
        	使用java描述一个矩形，矩形具备高、宽两个属性，还具备计算面积与周长的方法。
        	要求：一旦创建矩形对象时，那么该矩形对象就具备了高、宽两个属性值（不能使默认的初始值）
*/


public class Test {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println("矩形面积为:"+rectangle.area(12, 10));
        System.out.println("矩形面积为:"+rectangle.perimeter(12, 10));
    }
}
