package edu.tongji.comm.example.multithread.singletonperthreadV2;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 */
public class AppTest {

    public static void main(String[] args) {

        //主线程
        ThreadLocalFactory<Car> threadLocalFactory = new ThreadLocalFactory<>(() -> new Car());
        Car car = threadLocalFactory.create();
        System.out.println(Thread.currentThread().getName() + ":" + car);

        //开辟的新线程
        new Thread(() -> {
            ThreadLocalFactory<Car> threadLocalFactory1 = new ThreadLocalFactory<>(() -> new Car());
            Car car1 = threadLocalFactory1.create();
            System.out.println(Thread.currentThread().getName() + ":" + car1);
        }).start();


        /**
         * output:
         * main:edu.tongji.comm.example.multithread.singletonperthreadV2.Car@31cefde0
         Thread-0:edu.tongji.comm.example.multithread.singletonperthreadV2.Car@4926412a
         */

    }

}
