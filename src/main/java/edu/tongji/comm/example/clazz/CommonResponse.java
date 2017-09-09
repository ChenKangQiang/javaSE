package edu.tongji.comm.example.clazz;

import lombok.Data;

/**
 * @Author chenkangqiang
 * @Data 2017/9/9
 */

@Data
public class CommonResponse<T> {

    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "OK";

    private Integer code = SUCCESS_CODE;
    private String msg = SUCCESS_MSG;

    T data;

}
