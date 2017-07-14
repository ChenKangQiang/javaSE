package edu.tongji.comm.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chen on 2017/7/13.
 */
public class regexTest {

    public static void main(String[] args) {
        String URL1 = "http://i.meituan.com/jshfuiah";
        String URL2 = "http://m.dianping.com/jshfuiah";
        Pattern pattern = Pattern.compile("(.*)(i.meituan.com)(.*)");
        Matcher matcher1 = pattern.matcher(URL1);
        Matcher matcher2 = pattern.matcher(URL2);
        System.out.println(matcher1.find());
        System.out.println(matcher2.find());
    }

}
