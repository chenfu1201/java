package chenfu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: romantic_ke@163.com
 * @Description: 了解Calendar类的使用
 * @Date: 2018/12/6 22:16
 */
public class CalendarTest {

    /**
     * 根据传入的字符日期，找到对应的周末返回
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getWeekEndSeconds(String date) throws ParseException {

        Calendar cal = Calendar.getInstance();
//        转化字符串为时间和格式化时间戳用
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        首先将字符串格式化成Date类型，然后传递给Calendar对象
        cal.setTime(format.parse(date));
//        设置一周是从那一天开始，
//        SUNDAY代表是周日，MONDAY代表是从周一开始
        cal.setFirstDayOfWeek(Calendar.MONDAY);
//        设置一周是几天，
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//        设置偏移的小时
        cal.set(Calendar.HOUR_OF_DAY, 0);
//        设置偏移的分钟
        cal.set(Calendar.MINUTE, 0);
//        设置偏移的秒
        cal.set(Calendar.SECOND, 0);

        System.out.println(cal.getTimeInMillis());

//        将时间戳转化为时间
        return  format.format(cal.getTimeInMillis());
    }

    public static void main(String[] args) throws ParseException {

        String weekEndSeconds = getWeekEndSeconds("2018-11-26");

        System.out.println(weekEndSeconds);

    }

}
