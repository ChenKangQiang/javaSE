package edu.tongji.comm.example.date;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/9/20
 */
public class Demo {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime aaa = LocalDateTime.of(2018, 10, 7, 23, 59, 59);

        System.out.println(now);
        System.out.println(aaa.toString());
        System.out.println(now.isBefore(aaa));


        LocalDateTime cutoffTime = LocalDateTime.parse("2018-10-07T23:59:59");
        LocalDateTime ccc = LocalDateTime.parse(aaa.toString());
        System.out.println(ccc);
        System.out.println(cutoffTime.toString());

    }

}
