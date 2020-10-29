package HomeWork02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Car {
    private String color;
    private String name;
    private int tyre;

    public void run(){
        System.out.println(this.color+"的"+this.name+"正在冲冲冲!");
    }
}
