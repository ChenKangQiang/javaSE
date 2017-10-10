package edu.tongji.comm.example.multithread;


import java.util.Random;

/**
 * @Author chenkangqiang
 * @Data 2017/9/23
 */
public class ThreadLocalDemo implements Runnable {

    /**
     * ThreadLocal是绑定到特定线程的，所以要在run或call方法中赋初值
     */
    private static final ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    private ThreadLocal<Pat> patThreadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        Random random = new Random();
        int number = random.nextInt(100);
        //单例User
        User user = User.getInstance();
        System.out.println(user);
        user.setName("Tom" + number );
        user.setEmail("Tom" + number + "@163.com");
        userThreadLocal.set(user);
        System.out.println(userThreadLocal.get());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


