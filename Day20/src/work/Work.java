package work;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Work {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        work1();
//        work2();
//        work3();
//        work4();
//        work5();
//        work6();
        String s = work7(16, false,false ,false );
        System.out.println(s);
    }


    /**
     * 7.要求写一个工具类，可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）
     */
    public static String work7(int length,boolean letter,boolean upper,boolean number){
        String nums = "0123456789";
        String letterChars = "qwertyuiopasdfghjklzxcvbnm";
        String upperChars = "QWERTYUIOPASDFGHJKLZXCVBNM";
        //随机字符序列
        StringBuilder builder = new StringBuilder();
        if(letter){ //小写字母加入随机序列
            builder.append(letterChars);
        }
        if(upper){//大写字母加入随机序列
            builder.append(upperChars);
        }
        if(number){//数字字母加入随机序列
            builder.append(nums);
        }
        if(!letter && !upper && !number){ //都不加入,则默认将数字加入随机字符序列
            builder.append(nums);
        }
        Random random = new Random();
        char[] chars = builder.toString().toCharArray();
        StringBuilder result =  new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(builder.length());
            result.append(chars[index]);
        }
        return result.toString();
    }
    /**
     * 6.一个方法，要求传入时间和间隔天数，返回新的日期
     */
    public static void work6(){
        int days = 10;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        System.out.println("新的时间: " + calendar.getTime());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusDays(days);
        System.out.println("新的时间 : " + localDateTime);
    }

    /**
     * 5.计算两个时间相差几个小时
     */
    public static void work5(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = LocalDateTime.of(2020, 11, 4, 13, 05, 50);
        long until = after.until(now, ChronoUnit.HOURS);
        System.out.println("两个时间相差 :" + Math.abs(until));
    }
    /**
     * 4.获取一个月中的最后一天
     */
    public static void work4(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        int actualMaximum = calendar.getActualMaximum(Calendar.DATE);
        int actualMinimum = calendar.getActualMinimum(Calendar.DATE);
        System.out.println("当前天数字段的最大值 : "+actualMaximum);
        System.out.println("当前天数字段的最小值 : "+actualMinimum);
    }
    /**
     * 3.从命令行输入一个字符串！要求从中随机选择6个字符组成验证码！
     */
    public static void work3(){
        String input = scanner.next();
        //获取字符串的char数组
        char[] chars = input.toCharArray();
        //创建随机对象
        Random random = new Random();
        //创建字符串缓冲对象
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            //获取数组长度的随机数
            int randomIndex = random.nextInt(chars.length);
            //根据随机数取数组的元素
            char aChar = chars[randomIndex];
            builder.append(aChar);
        }
        System.out.println("随机字符为 : " + builder);
    }

    /**
     * 2.使用Calendar类的相关属性以及方法！打印出某年某个月的日历信息！（要求年月日由命令行输入）
     */
    public static void work2(){

        Calendar calendar = Calendar.getInstance();
        System.out.println("请输入年 : ");
        int year = scanner.nextInt();
        calendar.set(Calendar.YEAR, year);
        System.out.println("请输入月 : ");
        int month = scanner.nextInt();
        System.out.println("请输入日 : ");
        int day = scanner.nextInt();
        calendar.set(Calendar.MONTH, month-1); //Calendar 中的月份从0开始
        calendar.set(Calendar.DATE, day);
        System.out.println("时间日历 : " + calendar.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String format = simpleDateFormat.format(calendar.getTime());
        System.out.println("输入的时间 : " + format);
    }

    /**
     * 1.将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     */
    public static void work1(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("转换后的时间字符串 : " + format);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String format1 = formatter.format(now);
        System.out.println("LocalDateTime 格式化为时间格式字符串 :" + format1);
    }
}
