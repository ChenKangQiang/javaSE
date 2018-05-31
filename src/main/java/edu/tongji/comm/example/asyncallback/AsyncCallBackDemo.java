package edu.tongji.comm.example.asyncallback;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Description: java中异步回调Demo
 * @Author: chenkangqiang
 * @Date: 2018/5/13
 */
public class AsyncCallBackDemo {

    private RemoteService remoteService = new RemoteServiceImpl();

    private MyCallBack myCallBack;

    public AsyncCallBackDemo(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    /**
     * 线程池用于实现异步
     */
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncCallBackDemo demo = new AsyncCallBackDemo(new MyCallBack() {
            @Override
            public void doOnResourcesFromRemote(Map<String, String> result) {
                for (Map.Entry<String, String> entry : result.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }
        });

        demo.showAsyncCallBack(5);

        System.out.println("异步调用，先执行后续操作");
        TimeUnit.SECONDS.sleep(10);
        System.out.println("全部操作执行完毕");

    }


    public void showAsyncCallBack(Integer handTime) throws ExecutionException, InterruptedException {
        Future<Map<String, String>> future = executorService.submit(new calculateTask(handTime));
        while (true) {
            if (future.isDone()) {
                Map<String, String> resources = future.get();
                myCallBack.doOnResourcesFromRemote(resources);
            }
        }
    }


    /**
     * 异步所执行的任务
     */
    private class calculateTask implements Callable<Map<String, String>> {

        private Integer handTime;

        public calculateTask(Integer handTime) {
            this.handTime = handTime;
        }

        @Override
        public Map<String, String> call() throws Exception {
            return remoteService.getRemoteResources(handTime);
        }


    }




}
