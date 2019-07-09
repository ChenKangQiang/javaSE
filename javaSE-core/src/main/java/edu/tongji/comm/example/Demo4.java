package edu.tongji.comm.example;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/9/5
 */
public class Demo4 {

    public static void main(String[] args) {
        System.out.println(getIntervalHour(500L));
        System.out.println(getNextFetchTime(3650));
        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now());
        System.out.println(new Date().getTime());
        System.out.println(new Date(System.currentTimeMillis()));

        long aaa = System.currentTimeMillis();
        System.out.println(aaa / 1000);
        Instant expiration = Instant.ofEpochSecond(aaa / 1000 + 15 * 60);
        System.out.println(expiration.getEpochSecond());

        System.out.println(convertMtShopStar(13));

        System.out.println(new Long(116879510).hashCode() % 100);
        System.out.println(new Long(105068310).hashCode() % 100);
    }

    public static double getIntervalHour(Long intervalTime) {
        return (intervalTime / 60D) / 60D;
    }


    public static Integer getNextFetchTime(long intervalTime) {
        return (int) Math.ceil(24 - (intervalTime / 60D) / 60D);
    }




    public static long getTimestamp(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }



    public void sortByDate() throws InterruptedException {
        List<Item> dateList = Lists.newArrayList();
        dateList.add(new Item(new Date()));
        TimeUnit.SECONDS.sleep(10);
        dateList.add(new Item(new Date()));
        dateList.sort(Comparator.comparing(Item::getDate).reversed());
        System.out.println(dateList.get(0));
        System.out.println(dateList.get(1));
    }

    @AllArgsConstructor
    @Data
    private class Item {
        private Date date;
    }



    public static double convertMtShopStar(double shopStar) {
        String a = Double.toString(shopStar / 5d);
        BigDecimal b = new BigDecimal(a).setScale(0, BigDecimal.ROUND_HALF_UP);
        return b.intValue() * 5;
    }


}
