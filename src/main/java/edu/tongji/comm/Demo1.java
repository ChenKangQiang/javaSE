package edu.tongji.comm;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author chenkangqiang
 * @data 2017/12/25
 *
 * 根据GPS坐标计算距离
 */
public class Demo1 {


    public static void main(String[] args) {

        /*
        39.6902805948,94.2077636719

        41.1041909446,99.9865722656


        31.1090946134,121.4027023315

        31.1187943960,121.4388370514
        */

        System.out.println(getDistance(31.1090946134,121.4027023315,
                31.1187943960,121.4388370514));


        Map<Integer, List<Integer>> listMap = Maps.newHashMap();
        List<Integer> list = Lists.newArrayList(8020814, 15119046, 8822496, 1111111, 2222222);
        listMap.put(277, list);

        List<Integer> list1 = Lists.newArrayList(65589972, 65748787, 65945483, 333333, 444444);
        listMap.put(367, list1);
        System.out.println(JSON.toJSONString(listMap));


        String a = new String("hello");
        String b = new String("hello");
        String c = a;
        System.out.println(a == b); //false
        System.out.println(c == a);  //true
        System.out.println(a.equals(b));  //true

    }


    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s*1000;
        return s;
    }

}
