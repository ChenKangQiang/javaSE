package edu.tongji.comm.example.multithread.singletonperthreadV2;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 *
 * 抽象工厂类
 */

@FunctionalInterface
public interface Factory<T> {
    T create();
}
