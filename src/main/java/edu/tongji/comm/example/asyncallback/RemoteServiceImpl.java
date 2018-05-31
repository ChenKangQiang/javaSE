package edu.tongji.comm.example.asyncallback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/5/13
 */
public class RemoteServiceImpl implements RemoteService {
    @Override
    public Map<String, String> getRemoteResources(Integer handTime) {
        Map<String, String> resources = new HashMap<>();
        resources.put("name", "Tom");
        resources.put("age", "20");
        try {
            //模拟处理时长
            TimeUnit.SECONDS.sleep(handTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resources;
    }
}
