package util;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateUtils {
    /**
     * 计算两个时间的相差分钟数  字符串格式 yyyy-MM-dd HH:mm:ss
     * @param time1
     * @param time2
     * @return
     */
    @SneakyThrows
    static int getTime(String time1,String time2){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = simpleDateFormat.parse(time1);//借出时间字符串转换为时间格式对象
        Date parse1 = simpleDateFormat.parse(time2);// 归还时间字符串转换为时间格式对象

        long time = parse1.getTime() - parse.getTime();
        int minute = 1000*60;

        int time3 = (int)(time / minute);
        if(time % minute >0){
            time3 = time3+1;
        }
        return time3;
    }

    /**
     * 给出当前系统时间
     * @return
     */
    static String getTimeNow(){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

}
