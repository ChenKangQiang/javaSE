package edu.tongji.comm.example.thread.threadlocal.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-03
 */
public class C3P0Utils {

    private static DataSource source;//数据源
    static{
        source = new ComboPooledDataSource("mysql");//根据配置文件初始化数据源
    }

    /**
     * 获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

}
