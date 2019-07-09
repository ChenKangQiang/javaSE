package edu.tongji.comm.example.time;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-05-30
 */
public class LocalDateTimeTest {

    public static void main(String[] args) throws ParseException {
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
        System.out.println(NumberUtils.isCreatable("5.33"));
        String str = "2019-05-31T10:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        System.out.println(NumberUtils.toDouble("27.0"));
        System.out.println(NumberUtils.toDouble("27.5"));
        Date date = sdf.parse(str);
        System.out.println(new BigDecimal(23.0D).stripTrailingZeros().toPlainString());
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.toString());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00");
        String localTime = df.format(time);
        System.out.println(localTime);
        LocalDateTime ldt = LocalDateTime.parse(localTime, df);
        System.out.println(ldt.toString());
    }

}
