package utils;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-06-01
 */
public class DateUtils {


    /**
     * 字符串转日期
     *
     * @param str
     * @param format 字符串格式，如yyyy-MM-dd'T'HH:mm:ss，yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date stringToDate(String str, String format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        } catch (Exception ex) {
            //op
        }
        return date;
    }


    /**
     * Date转字符串
     *
     * @param date
     * @param format 字符串格式，如yyyy-MM-dd HH:mm:ss，yyyy-MM-dd'T'HH:mm:ss
     * @return
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String str = sdf.format(date);
        return str;
    }


    /**
     * LocalDateTime转字符串
     *
     * @param localDateTime
     * @param format
     * @return
     */
    public static String localDateTimeToString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        String str = df.format(localDateTime);
        return str;
    }


    /**
     * LocalDateTime转字符串
     *
     * @param str
     * @param format
     * @return
     */
    public static LocalDateTime stringToLocalDateTime(String str, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDateTime = LocalDateTime.parse(str, df);
        return localDateTime;
    }


    /**
     * 获取当天的所有整点时间
     *
     * @return
     */
    public static List<LocalDateTime> getTodaySharpTimes() {
        List<LocalDateTime> localDateTimeList = Lists.newArrayList();
        LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        LocalDateTime temp = todayStart;
        while (temp.isBefore(todayEnd)) {
            localDateTimeList.add(temp);
            temp = temp.plusHours(1);
        }
        return localDateTimeList;
    }


    /**
     * 获取当天的所有整点时间
     * 返回为Date形式
     *
     * @return
     */
    public static List<Date> getTodaySharpTimesByDateForm() {
        List<Date> dateList = Lists.newArrayList();
        LocalDateTime todayStart = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);

        LocalDateTime temp = todayStart;
        while (temp.isBefore(todayEnd)) {
            dateList.add(localDateTimeToDate(temp));
            temp = temp.plusHours(1);
        }
        return dateList;
    }


    /**
     * 获取任意一天的所有整点时间
     *
     * @return
     */
    public static List<LocalDateTime> getAnyDaySharpTimes(LocalDate anyDate) {
        List<LocalDateTime> localDateTimeList = Lists.newArrayList();
        LocalDateTime todayStart = LocalDateTime.of(anyDate, LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(anyDate, LocalTime.MAX);

        LocalDateTime temp = todayStart;
        while (temp.isBefore(todayEnd)) {
            localDateTimeList.add(temp);
            temp = temp.plusHours(1);
        }
        return localDateTimeList;
    }


    /**
     * 获取任意一天的所有整点时间
     * 返回为Date形式
     *
     * @return
     */
    public static List<Date> getAnyDaySharpTimesByDateForm(LocalDate anyDate) {
        List<Date> dateList = Lists.newArrayList();
        LocalDateTime todayStart = LocalDateTime.of(anyDate, LocalTime.MIN);
        LocalDateTime todayEnd = LocalDateTime.of(anyDate, LocalTime.MAX);

        LocalDateTime temp = todayStart;
        while (temp.isBefore(todayEnd)) {
            dateList.add(localDateTimeToDate(temp));
            temp = temp.plusHours(1);
        }
        return dateList;
    }


    /**
     * Date转LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }


    /**
     * LocalDateTime转Date
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
        return date;
    }


}
