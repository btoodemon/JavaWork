package HomeWork03;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Human {
    private int id;
    private String name;
    private int age;
    static int count = 0;

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        count++;
    }

    public static void compare(Human human1, Human human2) {
        int i = human1.getAge() - human2.getAge();
        if (i > 0) {
            System.out.println(human1.getName() + "比" + human2.getName() + "大" + i + "岁");
        } else if (i == 0) {
            System.out.println(human1.getName() + "与" + human2.getName() + "同岁");
        } else {
            System.out.println(human1.getName() + "比" + human2.getName() + "小" + (0-i) + "岁");
        }
    }


}
