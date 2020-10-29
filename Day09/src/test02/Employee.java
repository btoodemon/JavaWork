package test02;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class Employee {
    private int id;
    private String name;
    private String gender;
    private double salary;

    public Employee(int id, String name, String gender, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }
}
