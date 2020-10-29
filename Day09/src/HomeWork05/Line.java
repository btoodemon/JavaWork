package HomeWork05;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Line extends Graphics{
    private double xEndAxis;
    private double yEndAxis;

    public Line(double xAxis, double yAxis, String color, double xEndAxis, double yEndAxis) {
        super(xAxis, yAxis, color);
        this.xEndAxis = xEndAxis;
        this.yEndAxis = yEndAxis;
    }

    @Override
    public void draw() {
        System.out.println("线条绘图");

    }
}
