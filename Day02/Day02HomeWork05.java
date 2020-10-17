import java.util.Scanner;
public class Day02HomeWork05 {
    public static void main(String[] args) {
        /*
        计算用户输入的日期离1900年1月1日相距多少天
        */
        Scanner scanner = new Scanner(System.in);
        //dayAll 为总天数差距
        int dayAll;

        //dayAllY 为只算年的天数差距
        int dayAllY = 0;

        //dayAllM 为只算月份加日期的天数差距
        int dayAllM = 0;


        System.out.println("请输入年");
        int y = scanner.nextInt();
        System.out.println("请输入月");
        int m = scanner.nextInt();
        System.out.println("请输入日");
        int d = scanner.nextInt();



        //先计算从1900年到输入年份的只算年的天数
        if(y>=1900){
            //输入年份大于1900,从1900正着算到y年
            for(int i = 1900;i<y;i++){
                if( (i%4==0&&i%100!=0) || i%400==0){
                    dayAllY += 366;
                }else{
                    dayAllY += 365;
                }
            }


        }else {
            //输入年份小于1900年,从y年算到1900年
            for(int i = (y+1);i<1900;i++){
                if( (i%4==0&&i%100!=0) || i%400==0){
                    dayAllY += 366;
                }else{
                    dayAllY += 365;
                }
            }


        }


        //算月份的天数



        switch (m){
            case 12:
                dayAllM += 30;
            case 11:
                dayAllM += 31;
            case 10:
                dayAllM += 30;
            case 9:
                dayAllM += 31;
            case 8:
                dayAllM += 31;
            case 7:
                dayAllM += 30;
            case 6:
                dayAllM += 31;
            case 5:
                dayAllM += 30;
            case 4:
                dayAllM += 31;
            case 3:
                if((y%4==0&&y%100!=0) || (y%400==0)){
                    dayAllM += 29;
                }else {
                    dayAllM += 28;
                }
            case 2:
                dayAllM += 31;
            case 1:
                dayAllM += (d-1);//例如同一个月的2号和1号,只相差1天.这里减去初始的1号;
                break;
            default:
                System.out.println("输入月份错误");
        }


        if(y>1900){
            dayAll = dayAllY + dayAllM;
        }else if((y%4==0&&y%100!=0) || (y%400==0)){
            dayAll = dayAllY + (366 - dayAllM);
        }else {
            dayAll = dayAllY + (365 - dayAllM);
        }


        System.out.println("所输日期累计距1900年1月1日天数" + dayAll);
    }
}
