package edu.tongji.comm.example.reflect;

import lombok.Data;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/7/30
 */
@Data
public class ReflectBean {

    private String code;
    private String text;

    public static void show(int num, String desc, int b) {
        System.out.println(num + desc + b);
    }


    private void say(int ccc, String desc) {
        System.out.println(desc);
    }

}
