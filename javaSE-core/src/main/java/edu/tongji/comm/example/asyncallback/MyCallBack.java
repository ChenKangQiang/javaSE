package edu.tongji.comm.example.asyncallback;

import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/5/13
 */
public interface MyCallBack {
    void doOnResourcesFromRemote(Map<String, String> result);
}
