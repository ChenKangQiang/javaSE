package edu.tongji.comm.example.bigdecimal;

import java.math.BigDecimal;

/**
 * @author chenkangqiang
 * @date 2017/9/11
 */
public class Client {

    public static void main(String[] args) {
        Long long1 = new Long(12345678);
        Long long2 = new Long(12345678);
        BigDecimal bigDecimal = new BigDecimal(13.9);
        BigDecimal bigDecimal1 = new BigDecimal(12.1);
        BigDecimal bigDecimal2 = new BigDecimal(11);
        BigDecimal bigDecimal4 = new BigDecimal("0.00");
        BigDecimal bigDecimal5 = new BigDecimal("129.00");
        BigDecimal bigDecimal6 = new BigDecimal("139.99");
        BigDecimal bigDecimal7 = new BigDecimal("100.00");
        System.out.println(bigDecimal4.stripTrailingZeros().toPlainString());
        System.out.println(bigDecimal5.stripTrailingZeros().toPlainString());
        System.out.println(bigDecimal6.stripTrailingZeros().toPlainString());
        System.out.println(subZeroAndDot(bigDecimal4.toString()));
        System.out.println(subZeroAndDot(bigDecimal5.toString()));
        System.out.println(bigDecimal7.stripTrailingZeros().toPlainString());

        //最好以String的方式来初始化BigDecimal，否则double和float都会出现经度丢失
        BigDecimal bigDecimal3 = new BigDecimal("12.999");
        System.out.println(bigDecimal3.toString());
        String str1 = long1 + "";
        String str2 = long2 + "";
        String str3 = bigDecimal + "";
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.setScale(1, BigDecimal.ROUND_DOWN));
        System.out.println(bigDecimal1);
        System.out.println(bigDecimal1.setScale(1, BigDecimal.ROUND_DOWN));
        System.out.println(str3);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals("12345678"));
        System.out.println(str3.equals("13.9"));
        System.out.println(bigDecimal.scale());
        System.out.println(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(bigDecimal1.setScale(1, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(bigDecimal2.setScale(1, BigDecimal.ROUND_HALF_DOWN).intValueExact());
        System.out.println(bigDecimal3.toString());
    }


    /**
     * jdk1.7的stripTrailingZeros()存在bug
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s == null) {
            return s;
        }
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }


}
