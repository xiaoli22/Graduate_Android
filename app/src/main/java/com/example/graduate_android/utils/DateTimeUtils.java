package com.example.graduate_android.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeUtils {
    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取当前小时数（0~23）
     *
     * @return 当前小时数
     */
    public static int getCurrentHour() {
        // 获取当前时间的Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 获取当前小时数，并返回
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前分钟数
     *
     * @return 当前分钟数
     */
    public static int getCurrentMinute() {
        // 获取当前时间的Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 获取当前分钟数，并返回
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取当前秒数
     *
     * @return 当前秒数
     */
    public static int getCurrentSecond() {
        // 获取当前时间的Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 获取当前秒数，并返回
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取当前日期和时间的格式化字符串，格式为"yyyy年MM月dd日 HH:mm:ss"
     *
     * @return 当前日期和时间的格式化字符串
     */
    public static String getCurrentDateTime() {
        // 获取当前时间的Calendar对象
        Calendar calendar = Calendar.getInstance();
        // 创建SimpleDateFormat对象，指定日期和时间的格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss", Locale.getDefault());
        // 格式化当前时间，并返回格式化后的字符串
        return dateFormat.format(calendar.getTime());
    }


    // 获取这周星期一到这周星期日的日期
    public static String getDateOfCurrentWeek() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int days = dayOfWeek - 2;
        calendar.add(Calendar.DATE, -days);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        SimpleDateFormat f = new SimpleDateFormat("MM月dd日");
        String startDate = f.format(calendar.getTime());
        calendar.add(Calendar.DATE, 6);      // 加 6 天得到星期日的日期
        String endDate = f.format(calendar.getTime());
        return startDate + "-" + endDate;
    }

    //获取这个月的第一天和最后一天
    public static String getMonthFirstAndLastDay() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH); //获取本月第一天
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  //获取本月最后一天

        SimpleDateFormat f = new SimpleDateFormat("MM月dd日");
        calendar.set(Calendar.DAY_OF_MONTH, firstDay); // 设置为本月的第一天
        String monthFirstDay = f.format(calendar.getTime());

        calendar.set(Calendar.DATE, lastDay);        //设置calendar的日期为本月最后一天
        String monthLastDay = f.format(calendar.getTime());
        return monthFirstDay + "-" + monthLastDay;
    }

    //得到时间：year年month月
    public static String getCurrentYearAndMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        return year + "年" + month + "月";
    }

    //  获得今天是星期几
    public static String getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "星期日";
            case Calendar.MONDAY:
                return "星期一";
            case Calendar.TUESDAY:
                return "星期二";
            case Calendar.WEDNESDAY:
                return "星期三";
            case Calendar.THURSDAY:
                return "星期四";
            case Calendar.FRIDAY:
                return "星期五";
            case Calendar.SATURDAY:
                return "星期六";
            default:
                return "";
        }
    }
}
