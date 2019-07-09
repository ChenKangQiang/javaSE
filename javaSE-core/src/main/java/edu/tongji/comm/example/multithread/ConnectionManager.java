package edu.tongji.comm.example.multithread;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 */
public class ConnectionManager {

    private static final ThreadLocal<Connection> THREAD_LOCAL = ThreadLocal.withInitial(() -> new Connection());

    public static Connection getConnection() {
        return THREAD_LOCAL.get();
    }

}
