package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * 单例模式
 */
public class LoadBalancer {
    //私有静态成员变量，存储唯一实例
    private static LoadBalancer instance = null;
    //服务器集合
    private List serverList = null;

    //私有构造函数
    private LoadBalancer() {
        serverList = Lists.newArrayList();
    }

    //公有静态成员方法，返回唯一实例
    //多线程环境下，还是会出现多个实例
    public static LoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }

    //删除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }

    //使用Random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String)serverList.get(i);
    }

}

