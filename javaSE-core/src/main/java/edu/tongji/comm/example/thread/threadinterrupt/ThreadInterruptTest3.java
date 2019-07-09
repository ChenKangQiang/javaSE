package edu.tongji.comm.example.thread.threadinterrupt;

/**
 * @Description:
 * @Author: chenkangqiang
 * @Date: 2019-02-12
 */
public class ThreadInterruptTest3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadInterruptTest3.MyThread();
        t.start();
        //TimeUnit.MILLISECONDS.sleep(100);
        t.interrupt();
        System.out.println("已调用线程的interrupt方法");
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            long num = -1;
            try {
                num = longTimeRunningInterruptMethod(10);
            } catch (InterruptedException ex) {
                System.out.println("线程被中断");
                ex.printStackTrace();
            }
            System.out.println("长时间任务运行结束,num=" + num);
            //抛出中断异常后，线程的中断状态会被重置为false
            System.out.println("线程的中断状态:" + Thread.interrupted());
        }

        private long longTimeRunningInterruptMethod(int count) throws InterruptedException {
            long initNum = 0;
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("正式处理前线程已经被请求中断");
            }
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < Integer.MAX_VALUE; j++) {
                    if (Thread.currentThread().isInterrupted()) {
                        //回滚数据，清理操作等
                        throw new InterruptedException("线程正在处理过程中被中断");
                    }
                    initNum++;
                }
            }
            return initNum;
        }
    }

}
