package edu.tongji.comm.example.regex;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/29
 */
public class regexTest2 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String testUrl = "https://p0.meituan.net/merchantpic/dca918ba6635123a88abb59a4948a0981263279.jpg%40120w_90h_1e_1c_1l_80q%7Cwatermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20";
        String testUrl2 = "https://p0.meituan.net/merchantpic/dca918ba6635123a88abb59a4948a0981263279.jpg";
        String testUrl3 = "https://p0.meituan.net/merchantpic/dca918ba6635123a88abb59a4948a0981263279";
        String testUrl4 = "https://p0.meituan.net/merchantpic/dca918ba6635123a88abb59a4948a0981263279.png";

        String testUrl5 = "https://p0.meituan.net/merchantpic/dca918ba6635123a88abb59a4948a0981263279.JPG%40120w_90h_1e_1c_1l_80q%7Cwatermark%3D1%26%26r%3D1%26p%3D9%26x%3D2%26y%3D2%26relative%3D1%26o%3D20";

        String testUrl6 = "https://qcloud.dpfile.com/pc/uZdLj0cHPHgjld7ZbUgQikdB-iRVn8cE4rFGqZ495sAy_cPqaEoSFJzcLOzcnVpe.jpg";

        System.out.println(filterImageUrl(testUrl, "aaaa"));
        System.out.println(filterImageUrl(testUrl2, "aaaa"));
        System.out.println(filterImageUrl(testUrl3, "aaaa"));
        System.out.println(filterImageUrl(testUrl4, "aaaa"));
        System.out.println(filterImageUrl(testUrl5, "aaaa"));
        System.out.println(filterImageUrl(testUrl6, "aaaa"));

    }

    public static String filterImageUrl(String imageUrl, String defaultImageUrl) {
        try {
            imageUrl = URLDecoder.decode(imageUrl, "utf-8");
            System.out.println(imageUrl);
        } catch (UnsupportedEncodingException ex) {
            return defaultImageUrl;
        }
        Pattern pattern = Pattern.compile("https://[\\S]*@");
        Matcher matcher = pattern.matcher(imageUrl);
        if (matcher.find()) {
            return matcher.group(0).replaceAll("@", "");
        } else {
            return imageUrl;
        }
    }
}
