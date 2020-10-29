package HomeWork05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public abstract class Graphics {
    private double xAxis;
    private double yAxis;
    private String color;


    public abstract void draw();
}
