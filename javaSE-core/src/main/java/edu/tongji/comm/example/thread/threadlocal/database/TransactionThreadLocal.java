package edu.tongji.comm.example.thread.threadlocal.database;

import edu.tongji.comm.example.thread.threadlocal.database.C3P0Utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-03
 */
public class TransactionThreadLocal {

    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 返回当前线程的数据库连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection connection = CONNECTION_THREAD_LOCAL.get();
        if (connection == null) {
            connection = C3P0Utils.getConnection();
            CONNECTION_THREAD_LOCAL.set(connection);
        }
        return connection;
    }

    /**
     * 开启事务
     *
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    /**
     * 提交事务
     *
     * @throws SQLException
     */
    public static void commit() throws SQLException {
        getConnection().commit();
    }

    /**
     * 事务回滚
     *
     * @throws SQLException
     */
    public static void rollback() throws SQLException {
        getConnection().rollback();
    }

    /**
     * 关闭数据库
     *
     * @throws SQLException
     */
    public static void close() throws SQLException {
        getConnection().close();//关闭数据库
        CONNECTION_THREAD_LOCAL.remove();//将该线程的connection对象移除
    }

}
