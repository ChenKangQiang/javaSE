package edu.tongji.comm.design.pattern.singleton;

/**
 * @author chenkangqiang
 * @date 2017/8/28
 * @Description
 */
public class LoadBalancerThread implements Runnable {

    private LoadBalancer loadBalancer;

    @Override
    public void run() {
        loadBalancer = LoadBalancer.getLoadBalancer();
    }


    public LoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

}
