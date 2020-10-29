package HomeWork04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    private String name;
    private String color;

    public void move(){
        System.out.println(this.color+"的"+this.name+"gogogo了!");
    }
}
