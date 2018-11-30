package edu.tongji.comm.example;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mchange.lang.ByteUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import sun.net.util.IPAddressUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

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

        String en = encrypt(13475873453L);
        System.out.println(en);

        long de = decrypt(en);
        System.out.println(de);


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
    }


}
