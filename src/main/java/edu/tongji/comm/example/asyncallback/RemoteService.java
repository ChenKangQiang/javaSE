package edu.tongji.comm.example.asyncallback;

import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/5/13
 */
public interface RemoteService {
    Map<String, String> getRemoteResources(Integer handTime);
}
