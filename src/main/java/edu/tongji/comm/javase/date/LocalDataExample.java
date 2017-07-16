package edu.tongji.comm.javase.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

/**
 * Created by chen on 2017/7/16.
 * 演示java 8 中的日期类  LocalDate
 */
public class LocalDataExample {

    public static void main(String[] args) {

        //当前时间
        LocalDate today = LocalDate.now();
        System.out.println("Current Date = " + today);

        //通过输入来创建LocalDate
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific Date = " + firstDay_2014);

        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid date 'February 29' as '2014' is not a leap year

        //可以设置时区
        LocalDate todayShanghai = LocalDate.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("Current Date in IST = " + todayShanghai);

        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        //从基准日期1970-01-01开始设置LocalDate
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("365th day from base date = " + dateFromBase);

        //从自定义的基准日期开始设置LocalDate
        LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("100th day of 2014 = " + hundredDay2014);

    }
}
