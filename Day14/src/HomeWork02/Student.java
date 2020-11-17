package HomeWork02;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Student {
    private String name;
    private Integer age;

    public Student() {
        this.name = "大大大";
        this.age = 18;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
