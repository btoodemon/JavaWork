package HomeWork05;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rectangle extends Graphics{
    private double length;
    private double width;

    public Rectangle(double xAxis, double yAxis, String color, double length, double width) {
        super(xAxis, yAxis, color);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("矩形绘图");
    }
}
