package HomeWork03;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String name;
    private String color;
    private int tyreNum;

    public void run(){
        System.out.println("一辆"+this.color+"色的"+this.name+"车已经冲出了重庆高架!");
    }


}
