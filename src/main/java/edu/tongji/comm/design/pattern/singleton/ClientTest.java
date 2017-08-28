package edu.tongji.comm.design.pattern.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class ClientTest {

    @Test
    public void test() {
        //创建4个LoadBalancer对象
        LoadBalancer balancer1,balancer2,balancer3,balancer4;
        balancer1 = LoadBalancer.getLoadBalancer();
        balancer2 = LoadBalancer.getLoadBalancer();
        balancer3 = LoadBalancer.getLoadBalancer();
        balancer4 = LoadBalancer.getLoadBalancer();

        //判断服务器负载均衡器是否相同
        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4) {
            System.out.println("服务器负载均衡器具有唯一性！");
        }

        //增加服务器
        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer1.addServer("Server 3");
        balancer1.addServer("Server 4");

        //模拟客户端请求的分发
        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求至服务器： " + server);
        }
    }


    @Test
    public void testWithMultipleThread() {
        //创建2个LoadBalancer对象
        LoadBalancer balancer1,balancer2;
        LoadBalancerThread thread1 = new LoadBalancerThread();
        LoadBalancerThread thread2 = new LoadBalancerThread();
        new Thread(thread1).start();
        new Thread(thread2).start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balancer1 = thread1.getLoadBalancer();
        balancer2 = thread2.getLoadBalancer();
        System.out.println(balancer1);
        System.out.println(balancer2);

        if (balancer1 != balancer2) {
            System.out.println("服务器负载均衡器不具有唯一性！");
            return;
        }

        //判断服务器负载均衡器是否相同
        System.out.println("服务器负载均衡器具有唯一性！");

        //增加服务器
        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer1.addServer("Server 3");
        balancer1.addServer("Server 4");

        //模拟客户端请求的分发
        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求至服务器： " + server);
        }
    }


    @Test
    public void testLazySingletonWithSynchronized() {
        LazySingletonWithSynchronized singleton1, singleton2;
        SingletonThreadWithSynchronized thread1 = new SingletonThreadWithSynchronized();
        SingletonThreadWithSynchronized thread2 = new SingletonThreadWithSynchronized();
        new Thread(thread1).start();
        new Thread(thread2).start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        singleton1 = thread1.getLoadBalancer();
        singleton2 = thread2.getLoadBalancer();
        System.out.println(singleton1);
        System.out.println(singleton2);

        if (singleton1 != singleton2) {
            System.out.println("对象不具有唯一性！");
        } else {
            System.out.println("对象具有唯一性！");
        }
    }


}
