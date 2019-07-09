package edu.tongji.comm.example.interview;

/**
 * @Author chenkangqiang
 * @Data 2017/10/14
 */
public class Demo2 {

    public static void main(String[] args) {

    }

    /**
     *
     * @param n 无聊的人数
     * @param m 有聊的人数
     * @return
     */
    public static double needTime(int n, int m) {
        double time = 0;

        int a = n;
        int b = m;

        if (n > 1) {
            return needTime(n - 1, m + 1) * (1/(n - 1) * (1/(m - 1))) + needTime(n - 1, m + 1);
        } else {
            return 0;
        }

    }


    public static long ipToLong(String strIp) {
        String[]ip = strIp.split("\\.");
        return (Long.parseLong(ip[0]) << 24) + (Long.parseLong(ip[1]) << 16) + (Long.parseLong(ip[2]) << 8) + Long.parseLong(ip[3]);
    }

}
