package edu.tongji.comm.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chen on 2017/7/13.
 */
public class regexTest {

    private static final String aaa = "https://(?!(\\.jpg|\\.png)).+?(\\.jpg|\\.png)";
    private static final String DEFAULT_COMMENT_IMAGE = "https://p0.meituan.net/dpnewvc/1f6b41f6781940105de16e537273d0ea284771.png";

    public static void main(String[] args) {
        String URL1 = "http://i.meituan.com/jshfuiah";
        String URL2 = "http://m.dianping.com/jshfuiah";
        Pattern pattern = Pattern.compile("(.*)(i.meituan.com)(.*)");
        Matcher matcher1 = pattern.matcher(URL1);
        Matcher matcher2 = pattern.matcher(URL2);
        System.out.println(matcher1.find());
        System.out.println(matcher2.find());


        System.out.println(filterImageUrl("https://p0.meituan.net/shaitu/b940d7f78dc5e3ce7353c00e3594dc2061856.jpg%40watermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://img.meituan.net/joy/ac31103c5c21189016bec8663cb29c861282199.jpg", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://img.meituan.net/joy/ac31103c5c21189016bec8663cb29c861282199.mp4", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://img.meituan.net/joy/ac31103c5c21189016bec8663cb29c861282199.png", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://p0.meituan.net/ugcpic/df8e7a343cf5774ca0678c44ac6f8793", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://qcloud.dpfile.com/pc/9ao_TdvuxN-AL_hJw6JnKfPu9toxaILYqtCPetbH7HrI0wzxHgDp03bKX2Jq3a6C.jpg", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://p0.meituan.net/shaitu/35f06d8acae3e5728ec9d7783d5d0b39144098.jpg%40watermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20", DEFAULT_COMMENT_IMAGE));
        System.out.println(filterImageUrl("https://p0.meituan.net/shaitu/810c354c6b0473ba5a4a78a3607695eb2203860.jpg@360w_360h_1e_1c%7C40watermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20", DEFAULT_COMMENT_IMAGE));
    }



    public static String filterImageUrl(String imageUrl, String defaultImageUrl) {
        String regex = "https://[\\S]*(\\.jpg|\\.png)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(imageUrl);
        if (matcher.find()) {
            return matcher.group(0);
        } else {
            return defaultImageUrl;
        }
    }

}
