package edu.tongji.comm.example.reflections;

import com.alibaba.fastjson.JSON;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-28
 */
public class Scan {

    public static void main(String[] args) {
        Reflections reflections = new Reflections(DependencyConfig.class);
        Set<Class<? extends DependencyConfig>> classes = reflections.getSubTypesOf(DependencyConfig.class);
        classes.forEach(clazz -> {
            try {
                System.out.println(clazz.getName());
                Method method = clazz.getMethod("buildInOutKeyDependency", null);
                Map<List<String>, List<String>> result = (Map<List<String>, List<String>>) method.invoke(clazz.newInstance(), null);
                System.out.println(JSON.toJSONString(result));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

}
