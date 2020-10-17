import java.util.Scanner;

public class Day01HomeWork {
    public static void main(String[] args){
        /* 作业1
         * 求一光年是多少千米 , 光在真空中传播速度299792458 m/s
         *
         */
        int lightSpeed = 299792458;
        long lightSpeedY = lightSpeed *365 *24 *60 *60 /1000; //一年=365天x24小时x60分x60秒
        System.out.println("一光年是" + lightSpeedY + "千米");
        System.out.println("----------------------------------------");


        /* 作业2
         * 根据天数（46）计算周数和剩余的天数
         *
         */
        int dayCount = 46;
        int weekCount = dayCount /7;
        int dayLeftCount = dayCount %7;
        System.out.println("天数" + dayCount + "计算的周数为" + weekCount + "剩余天数为" + dayLeftCount);
        System.out.println("----------------------------------------");


        /* 作业3
         * 已知圆的半径radius= 1.5，求其面积
         *
         */
        double circleRadius = 1.5;
        double circleArea = Math.pow(circleRadius,2) *3.14; // 数学π -> Math.PI
        System.out.println("已知圆的半径radiu=1.5 其面积为" + circleArea);
        System.out.println("----------------------------------------");


        /* 作业4
         * 自己给定5个整数，通过编程求出最大值(使用三元运算符)
         *
         */
        System.out.println("请输入5个整数");
        Scanner numInt = new Scanner(System.in);
        int numTest1 = numInt.nextInt();
        int numTest2 = numInt.nextInt();
        int numTest3 = numInt.nextInt();
        int numTest4 = numInt.nextInt();
        int numTest5 = numInt.nextInt();
        int numMax = (numTest1>numTest2)?numTest1:numTest2;
        numMax = (numTest3>numMax)?numTest3:numMax;
        numMax = (numTest4>numMax)?numTest4:numMax;
        numMax = (numTest5>numMax)?numTest5:numMax;
        System.out.println("5个数中最大值为" + numMax);
        System.out.println("----------------------------------------");


        /* 作业5
         * 韩梅梅看中两把价格相同的扇子，想挑选一个扇面较大的扇子购买，请你帮她挑选。
         * A款折叠扇：展开后角度为134.6°,扇骨长26.5cm
         * B款圆扇：扇柄长12.3cm，扇子总长度36.5cm
         * 注：圆形面积 = 3.14 * 半径平方
 	     * 扇形面积 = 3.14 * 半径平方 * (度数/360)
 	     * Java中π用Math.PI表示
         */
        double fanFold = 3.14 *Math.pow(26.5,2) *(134.6 /360);//Math.pow(x,y)
        double fanCircle = 3.14 *Math.pow(((36.5 -12.3)/2),2);    //x	必需。底数。必须是数字。y	必需。幂数。必须是数字。
        String chooseFan = (fanFold>fanCircle)?"A款折叠扇":"B款圆扇";
        System.out.println("A款折叠扇的扇面面积为" + fanFold + "cm^2");
        System.out.println("B款圆扇的扇面面积为" + fanCircle + "cm^2");
        System.out.println("应选择" + chooseFan);
        System.out.println("----------------------------------------");


        /* 作业5
         * 变量a和b的值互换  例如：int a = 10,b=20;  结果：a=20,b=10;
         *
         */
        int aTest = 10 ,bTset=20;
        System.out.println("交换前 a=" + aTest + "b=" + bTset);
        int changeTest = aTest;
        aTest = bTset;
        bTset = changeTest;
        System.out.println("交换后 a=" + aTest + "b=" + bTset);
        System.out.println("----------------------------------------");


        /* 作业6
         * 定义一个变量，是一个三位数，求各个位数的和. 如：123，结果是1+2+3=6
         */
        System.out.println("输入一个三位数");
        int numTest6 = numInt.nextInt();
        int numHund = numTest6 /100;
        int numTen = (numTest6 %100) /10;
        int numUnit = numTest6 %10;
        int numSum = numHund +numTen +numUnit;
        System.out.println("此三位数各个位数的和为" + numSum);
        System.out.println("----------------------------------------");


        /* 作业7
         * 定义今日温度，单位摄氏度，求对应华氏度是多少
         * 摄氏度 = (华氏度 - 32) * 5 / 9
         */
        System.out.println("请输入今日温度");
        double tempS = numInt.nextDouble();
        double tempH = tempS *9 /5 +32;
        System.out.println("今日对应华氏度为" + tempH);

    }
}
