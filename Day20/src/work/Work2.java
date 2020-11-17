package work;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Work2 {
    public static void main(String[] args) {
//        work1();
//        work3();
        work5();
    }

    public static void work5(){
        //科特迪瓦,阿根廷,澳大利亚,塞尔维亚,荷兰,尼日利亚,日本,美国,中国,新西 兰,巴西,比利时,韩国,喀麦隆,洪都拉斯,意大利
        ArrayList<String> list = new ArrayList<>();
        list.add("科特迪瓦");list.add("阿根廷");list.add("澳大利亚");list.add("塞尔维亚");list.add("荷兰");list.add("尼日利亚");list.add("日本");
        list.add("美国");list.add("中国");list.add("新西兰");list.add("巴西");list.add("比利时");list.add("韩国");list.add("喀麦隆");list.add("洪都拉斯");list.add("意大利");
        ArrayList<String> group1 = new ArrayList<>();
        ArrayList<String> group2 = new ArrayList<>();
        ArrayList<String> group3 = new ArrayList<>();
        ArrayList<String> group4 = new ArrayList<>();
        Random random = new Random();
        while (list.size()>0){
            int i = random.nextInt(list.size());
            String remove = list.remove(i);
            if (group1.size()<4) {
                group1.add(remove);
            } else if (group2.size()<4) {
                group2.add(remove);
            } else if (group3.size()<4) {
                group3.add(remove);
            }else if (group4.size()<4) {
                group4.add(remove);
            }
        }

        System.out.println("分组1: "+group1);
        System.out.println("分组2: "+group2);
        System.out.println("分组3: "+group3);
        System.out.println("分组4: "+group4);

    }

    public static void work3(){

        String[] weekStr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

        String input = "2020-11-5";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = format.parse(input);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            int i = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println(weekStr[i-1]);

            LocalDate localDate = LocalDate.now();
            int value = localDate.getDayOfWeek().getValue();
            System.out.println(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void work1(){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SE(1, "张三"));
        employees.add(new SE(2, "李四"));
        employees.add(new PM(1, "王五"));
        employees.add(new PM(2, "赵六"));

        employees.forEach(e->{
            e.show();
        });
    }
}
