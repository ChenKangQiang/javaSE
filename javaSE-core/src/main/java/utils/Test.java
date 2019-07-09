package utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-06-01
 */
public class Test {

    public static void main(String[] args) {
//        List<LocalDateTime> sharpTimes = DateUtils.getTodaySharpTimes();
//        System.out.println(sharpTimes);
//
//        List<LocalDateTime> anyDaySharpTimes = DateUtils.getAnyDaySharpTimes(LocalDate.now().minusDays(1));
//        System.out.println(anyDaySharpTimes);
//
//        LocalDateTime now = LocalDateTime.now();
//        Date date = DateUtils.localDateTimeToDate(now);
//        System.out.println(date);

//        List<Date> dates = DateUtils.getTodaySharpTimesByDateForm();
//        System.out.println(dates);
//
//        DateEntity dateEntity = new DateEntity();
//        dateEntity.setDate(new Date());
//        dateEntity.setName("123");
//        String value = JSON.toJSONString(dateEntity);
//        System.out.println(value);
//
//        DateEntity dateEntity1 = JSON.parseObject(value, DateEntity.class);
//        System.out.println(dateEntity1);

//        System.out.println(DateUtils.localDateTimeToString(LocalDateTime.now(), "HH:00"));
//
//        LocalDateTime localDateTime = DateUtils.stringToLocalDateTime("2019-06-11T19:00", "yyyy-MM-dd'T'HH:mm");
//
//        LocalDateTime localDateTime2 = DateUtils.stringToLocalDateTime(LocalDate.now().toString() + " " + "19:00", "yyyy-MM-dd HH:mm");
//        System.out.println(localDateTime2);
//
//        System.out.println(LocalDate.now().toString());
//
//        System.out.println(localDateTime);

    }


    @Data
    private static class DateEntity {
        private Date date;
        private String name;
    }

}
