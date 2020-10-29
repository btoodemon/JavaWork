package HomeWork02;

public class Driver {
    private Driver(){

    }


    public static void drive(Car car){
        if (car instanceof BMW){
            System.out.println(car.getTyre()+"轮的");
            car.run();
        }else if (car instanceof Benz){
            System.out.println(car.getTyre()+"轮の");
            car.run();
        }
    }
}
