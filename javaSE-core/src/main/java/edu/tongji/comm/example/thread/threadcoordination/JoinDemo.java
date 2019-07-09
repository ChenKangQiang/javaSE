package edu.tongji.comm.example.thread.threadcoordination;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-03-01
 */
public class JoinDemo {

    private static String str = null;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("进入" + Thread.currentThread().getName() + "线程");
                Thread.sleep(1000);
                str = "hello World";
                System.out.println(Thread.currentThread().getName() + "线程业务处理完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();//设置main线程等待子线程先处理业务
            System.out.println(Thread.currentThread().getName() + "线程处理业务开始");
            System.out.println("获取str值：" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
