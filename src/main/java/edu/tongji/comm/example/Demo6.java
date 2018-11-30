package edu.tongji.comm.example;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/10/12
 */
public class Demo6 {
    public static void main(String[] args) {
        List<Object> list1 = Lists.newArrayList();
        Map<Integer, String> map1 = Maps.newHashMap();
        map1.put(2, "哈哈哈");
        list1.add(new Integer(1));
        list1.add("aaa");
        list1.add(map1);

        List<Object> list2 = Lists.newArrayList();
        Map<Integer, String> map2 = Maps.newHashMap();
        map2.put(2, "哈哈哈");
        list2.add(new Integer(1));
        list2.add("aaa");
        list2.add(map2);

        System.out.println(list1.equals(list2));

        System.out.println(filterKey("111", "222", "333"));
        System.out.println(filterKey("444", null, null));

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());

        System.out.println(getThreadName("joy-event-activity-service-thread-36-test"));
        System.out.println(getThreadName("joy-event-activity-service-thread-3690"));
        System.out.println(getThreadName("joy-event-activity-service-thread-3690-bfuai"));
        System.out.println(getThreadName("joy-event-activity-service-thread-"));

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.substring(0, 0));
    }


    private static String filterKey(String... keyEnums) {
        if (keyEnums == null || keyEnums.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String keyEnum : keyEnums) {
            if (keyEnum != null) {
                stringBuilder.append(keyEnum).append(",");
            }
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        } else {
            return "";
        }
    }



    public static String getThreadName(String str) {
        String regEx = "joy-event-activity-service-thread-(\\d+)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }



}
