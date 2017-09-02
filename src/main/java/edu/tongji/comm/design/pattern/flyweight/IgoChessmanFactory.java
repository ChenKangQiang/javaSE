package edu.tongji.comm.design.pattern.flyweight;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 享元工厂类
 */
public class IgoChessmanFactory {

    //充当享元池
    private static Map<String, IgoChessman> map = Maps.newHashMap();

    /**
     * 使用静态内部来实现单例
     */
    private static class classHolder {
        private static IgoChessmanFactory instance = new IgoChessmanFactory();
    }

    private IgoChessmanFactory() {
        IgoChessman black, white;
        black = new BlackIgoChessman();
        map.put("b", black);
        white = new WhiteIgoChessman();
        map.put("w", white);
    }

    //返回享元工厂类的唯一实例
    public static IgoChessmanFactory getInstance() {
        return classHolder.instance;
    }

    //通过key来获取存储在Hashtable中的享元对象
    public static IgoChessman getIgoChessman(String color) {
        return map.get(color);
    }


}
