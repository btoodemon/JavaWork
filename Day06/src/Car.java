import java.util.Scanner;

public class Car {
    int wheel ;
    String color;

    public Car(int wheel1,String color1){
        wheel = wheel1;
        color = color1;
        System.out.println("车辆轮胎数"+wheel+"\t车辆颜色"+color);
    }

    public void run(){
        if(wheel==4){
            System.out.println("车四轮俱在,可以正常启动!");
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("您的汽车轮胎损坏,请选择以下维修:");
            Garage garage1 = new Garage("武汉汽车维修公司","武汉解放路10号",13700010001L);
            Garage garage2 = new Garage("武汉蓝翔汽修","武汉三二路1号",15000020002L);
            Garage garage3 = new Garage("武汉之星4s店","武汉星星路4号",18600030003L);
            int i =scanner.nextInt();
            System.out.println("请等待,已为您联系维修!");
            switch (i){
                case 1:
                    garage1.carRepairing();
                    break;
                case 2:
                    garage2.carRepairing();
                    break;
                case 3:
                    garage3.carRepairing();
                    break;
                default:
                    System.out.println("错误输入,选择默认维修公司!");
                    garage1.carRepairing();

            }

        }
    }

}
