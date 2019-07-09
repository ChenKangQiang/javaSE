package edu.tongji.comm;

import com.google.common.collect.Lists;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-07-07
 */
public class MySQLClassLoader {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }

        System.out.println("current thread contextLoader:" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader loader:" + ServiceLoader.class.getClassLoader());


        //修改ContextClassLoader后
        Thread.currentThread().setContextClassLoader(MySQLClassLoader.class.getClassLoader().getParent());
        System.out.println(Thread.currentThread().getContextClassLoader());

        ServiceLoader<Driver> loader2 = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator2 = loader2.iterator();
        while (iterator2.hasNext()) {
            Driver driver = iterator2.next();
            System.out.println("driver:" + driver.getClass() + ", loader:" + driver.getClass().getClassLoader());
        }
    }



    public List<Driver> load(Class clazz) {
        List<Driver> drivers = Lists.newArrayList();
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            drivers.add(driver);
            System.out.println("driver:" + driver.getClass() + ", loader:" + driver.getClass().getClassLoader());
        }
        return drivers;
    }








}
