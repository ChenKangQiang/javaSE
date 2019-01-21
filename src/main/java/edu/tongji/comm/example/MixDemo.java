package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mchange.lang.ByteUtils;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import sun.net.util.IPAddressUtil;

import javax.lang.model.SourceVersion;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2018/11/21
 */
public class MixDemo {

    private static final int RADIX = 16;
    private static final String SEED = "093391084746382923231231217717097564";

    public static String encrypt(long userId) {
        BigInteger bigInteger = new BigInteger(String.valueOf(userId).getBytes());
        BigInteger confuse = new BigInteger(SEED);
        bigInteger = bigInteger.xor(confuse);
        return bigInteger.toString(RADIX);
    }

    public static long decrypt(String encrypted) {
        BigInteger confuse = new BigInteger(SEED);
        BigInteger bigInteger = new BigInteger(encrypted, RADIX);
        bigInteger = bigInteger.xor(confuse);
        return NumberUtils.toLong(new String(bigInteger.toByteArray()));
    }

    public static void main(String args[]) {

        Set<Integer> integers = Sets.newHashSet(1, 2, 3, 4);
        Integer[] fffff = integers.toArray(new Integer[integers.size()]);
        System.out.println(fffff[0]);
        System.out.println(fffff[1]);
        System.out.println(fffff[2]);
        System.out.println(fffff[3]);

        List<List<Map<Integer, Object>>> list1 = Lists.newArrayList();
        Object list2 = list1;
        List<List<Map<Integer, List<Object>>>> list3 = cast(list2);
        System.out.println(list3.size());

        Map<Integer, Object> map1 = Maps.newHashMap();
        Map<Integer, String> map2 = Maps.newHashMap();
        map2.put(111, "hhhhhh");
        Object map4 = null;
        map4 = map2;
        map1 = (Map<Integer, Object>) map4;

        //map1 = (Map<Integer, Object>) map2;
        //map1 = cast(map2);
        System.out.println(map1);
        System.out.println(map1.get(111));

        JSONObject jsonObject = JSON.parseObject("{}");
        System.out.println(jsonObject.getString("pic"));


        //Boolean test = null;
        System.out.println("bbbbbbbb");
        System.out.println(null instanceof Boolean);

        System.out.println(Object.class.equals(boolean.class));

        int nnnn = 100;
        String mmm = String.valueOf(-nnnn);
        System.out.println(String.valueOf(-nnnn));


        System.out.println(NumberUtils.toLong("123"));
        System.out.println(NumberUtils.toInt("123"));

        System.out.println(NumberUtils.toDouble("123.4"));
        System.out.println(NumberUtils.toFloat("123.4"));
        System.out.println("aaa" + 1);

        Map<String, Class> ccc = Maps.newHashMap();
        ccc.put("1", Integer.class);
        ccc.put("2", String.class);
        System.out.println(ccc);

        PicConfig picConfig = JSON.parseObject("{\"width\":602,\"height\":250}", PicConfig.class);


        PicConfig picConfig2 = JSON.parseObject("{\"width\":602,\"height\":250,\"ccc\":100}", PicConfig.class);
        System.out.println(JSON.toJSONString(picConfig2));

        String en = encrypt(13475873453L);
        System.out.println(en);

        long de = decrypt(en);
        System.out.println(de);

        System.out.println(encrypt(1L).toUpperCase());
        System.out.println(encrypt(2L).toUpperCase());
        System.out.println(encrypt(200L).toUpperCase());

        System.out.println(getBeanName(MixDemo.class));

        List<String> tags1 = Lists.newArrayList("舞者", "DJ", "主场歌手");
        List<String> tags2 = Lists.newArrayList("hahhahha", "DJ", "主场歌手");
        System.out.println(JSON.toJSONString(tags1));
        tags1.remove("舞者");
        tags2.remove("舞者");
        System.out.println(JSON.toJSONString(tags1));
        System.out.println(JSON.toJSONString(tags2));


        String ipv6_1 = "::ffff:21:7.8.9.221";
        String ipv6_2 = "2001:0db8:85a3:08d3:1319:8a2e:0370:7344";
        String ipv6_3 = "::8a2e:0:0370:7344";
        String ipv6_4 = "2001:0db8:85a3:08d3:1319:8a2e:100.22.44.55";
        String ipv6_5 = "2001:0db8::8a2e:100.22.44.55";
        String ipv6_6 = "::100.22.44.55";
        String ipv6_7 = "ffff::";
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_1));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_2));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_3));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_4));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_5));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_6));
        System.out.println(IPAddressUtil.isIPv6LiteralAddress(ipv6_7));


        List<List<Set<Integer>>> filtersListList = Lists.newArrayList();

        List<Set<Integer>> subList = Lists.newArrayList();
        subList.add(Sets.newHashSet(1, 2, 3));
        filtersListList.add(subList);

        List<List<Map<Integer, List<Object>>>> result1 = init(filtersListList, List.class);
        List<List<Map<Integer, Object>>> result2 = init(filtersListList, Object.class);
        List<List<Map<Integer, Boolean>>> result3 = init(filtersListList, Boolean.class);
        List<List<Map<Integer, Boolean>>> result4 = init(filtersListList, boolean.class);
        System.out.println(result1);
        System.out.println(CollectionUtils.isNotEmpty(result1.get(0).get(0).get(1)));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }



    public static String getBeanName(Class clazz) {
        String simpleName = clazz.getSimpleName();
        return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    }



    @Data
    public static class PicConfig {
        private Integer width;
        private Integer height;
    }



    public static <T> T cast(Object obj) {
        if (obj != null) {
            try {
                return (T) obj;
            } catch (ClassCastException e) {

            }
        }
        return null;
    }




    private static  <T> List<List<Map<Integer, T>>> init(List<List<Set<Integer>>> filtersListList, Class clazz) {
        Object result = null;
        if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
            result = filtersListList.stream().map(
                    list -> list.stream().map(
                            set -> {
                                Map<Integer, Boolean> map = Maps.newHashMap();
                                set.forEach(filter -> map.put(filter, Boolean.FALSE));
                                return map;
                            }).collect(Collectors.toList())).collect(Collectors.toList());
        } else {
            result = filtersListList.stream().map(
                    list -> list.stream().map(
                            set -> {
                                Map<Integer, T> map = Maps.newHashMap();
                                set.forEach(filter -> map.put(filter, null));
                                return map;
                            }).collect(Collectors.toList())).collect(Collectors.toList());
        }
        return cast(result);
    }


}
