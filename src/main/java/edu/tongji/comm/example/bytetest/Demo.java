package edu.tongji.comm.example.bytetest;

import java.io.UnsupportedEncodingException;

/**
 * @Author chenkangqiang
 * @Data 2017/10/17
 */
public class Demo {

    public static void main(String[] args) {
        String str1 = "abcd";
        try {
            byte[] bytes = str1.getBytes("UTF-8");
            System.out.println(bytes);
            System.out.println(bytes.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
