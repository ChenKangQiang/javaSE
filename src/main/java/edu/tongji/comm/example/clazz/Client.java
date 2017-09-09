package edu.tongji.comm.example.clazz;

import org.junit.Test;

/**
 * @Author chenkangqiang
 * @Data 2017/9/9
 */
public class Client {

    @Test
    public void test() {
        CommonResponse<Student> studentResponse = new CommonResponse<>();
        System.out.println(CommonResponse.class);
        System.out.println(studentResponse.getClass());
    }



}
