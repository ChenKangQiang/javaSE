package edu.tongji.comm.example.reflections;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-28
 */
public interface DependencyConfig {

    Map<List<String>, List<String>> buildInOutKeyDependency();

    Map<List<String>, String> buildInOutKeyFilterMap();

}
