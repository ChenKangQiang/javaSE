package edu.tongji.comm.design.pattern.proxy;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

/**
 * 身份验证类
 */
public class AccessValidator {

    public boolean validate(Integer userId) {
        if ("杨过".equals(userId + "")) {
            System.out.println("登录成功 userId=" + userId);
            return true;
        } else {
            System.out.println("登录失败 userId=" + userId);
            return false;
        }
    }
}
