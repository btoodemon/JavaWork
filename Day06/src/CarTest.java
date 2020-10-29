import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("汽车轮胎数:");
        int i = scanner.nextInt();
        System.out.print("汽车颜色:");
        String j = scanner.next();
        Car car1 = new Car(i,j);
        car1.run();
    }


}
