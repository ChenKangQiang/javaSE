package edu.tongji.comm.design.pattern.builder;

import lombok.Data;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */
@Data
public class Actor {
    /**
     * 角色类型
     */
    private  String type;
    /**
     * 性别
     */
    private  String sex;
    /**
     * 脸型
     */
    private  String face;
    /**
     * 服饰
     */
    private  String costume;
    /**
     * 发型
     */
    private  String hairstyle;
}
