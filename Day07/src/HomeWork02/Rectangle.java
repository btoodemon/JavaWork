package HomeWork02;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Rectangle {
    private double high;
    private double wide;


    public double area(double high,double wide) {
        double a = high * wide;
        return a;

    }

    public double perimeter(double high,double wide) {
        double p = 2 * (high + wide);
        return p;

    }

}
