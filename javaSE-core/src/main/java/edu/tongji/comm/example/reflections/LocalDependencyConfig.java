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
public class LocalDependencyConfig implements DependencyConfig {

    @Override
    public Map<List<String>, List<String>> buildInOutKeyDependency() {
        Map<List<String>, List<String>> result = Maps.newHashMap();
        result.put(Lists.newArrayList("aaa", "bbb"), Lists.newArrayList("ccc", "ddd"));
        return result;
    }

    @Override
    public Map<List<String>, String> buildInOutKeyFilterMap() {
        return null;
    }

}
