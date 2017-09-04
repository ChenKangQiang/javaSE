package edu.tongji.comm.example.utiltest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author chenkangqiang
 * @date 2017/9/4
 */
public class Client {

    @Test
    public void test() {
        Date date = new Date();
        System.out.println(DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
    }

}
