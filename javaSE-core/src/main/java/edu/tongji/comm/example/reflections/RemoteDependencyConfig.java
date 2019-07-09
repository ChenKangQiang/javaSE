package edu.tongji.comm.example.reflections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-28
 */
public class RemoteDependencyConfig implements DependencyConfig {

    @Override
    public Map<List<String>, List<String>> buildInOutKeyDependency() {
        Map<List<String>, List<String>> result = Maps.newHashMap();
        result.put(Lists.newArrayList("1111", "222"), Lists.newArrayList("333", "444"));
        return result;
    }

    @Override
    public Map<List<String>, String> buildInOutKeyFilterMap() {
        return null;
    }
}
