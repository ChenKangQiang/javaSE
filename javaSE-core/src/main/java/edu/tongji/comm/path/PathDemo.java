package edu.tongji.comm.path;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.ServiceLoader;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-07-05
 */
public class PathDemo {

    public static void main(String[] args) {

        URL url1 = PathDemo.class.getResource("META-INF/app.properties");
        URL url2 = PathDemo.class.getResource("/META-INF/app.properties");
        URL url3 = PathDemo.class.getClassLoader().getResource("META-INF/app.properties");
        URL url4 = PathDemo.class.getClassLoader().getResource("/META-INF/app.properties");
        URL url5 = Thread.currentThread().getContextClassLoader().getResource("META-INF/app.properties");
        URL url6 = Thread.currentThread().getContextClassLoader().getResource("/META-INF/app.properties");

        System.out.println("url1: " + url1);
        System.out.println("url2: " + url2);
        System.out.println("url3: " + url3);
        System.out.println("url4: " + url4);
        System.out.println("url5: " + url5);
        System.out.println("url6: " + url6);

        try {
            //spring
            Resource resource1 = new ClassPathResource("META-INF/app.properties");
            URL url7 = resource1.getURL();
            System.out.println("url7: " + url7);

            Resource resource2 = new ClassPathResource("/META-INF/app.properties");
            URL url8 = resource2.getURL();
            System.out.println("url8: " + url8);

            try {
                Resource resource3 = new ClassPathResource("META-INF/app.properties", PathDemo.class);
                URL url9 = resource3.getURL();
                System.out.println("url9: " + url9);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Resource resource4 = new ClassPathResource("/META-INF/app.properties", PathDemo.class);
            URL url10 = resource4.getURL();
            System.out.println("url10: " + url10);

        } catch (IOException e) {

        }
    }

}
