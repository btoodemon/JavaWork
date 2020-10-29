package HomeWork05;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Circle extends Graphics{
    private double radius;

    public Circle(double xAxis, double yAxis, String color, double radius) {
        super(xAxis, yAxis, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("圆形绘图");
    }
}
