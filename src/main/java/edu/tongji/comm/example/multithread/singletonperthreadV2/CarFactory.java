package edu.tongji.comm.example.multithread.singletonperthreadV2;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 */
public class CarFactory implements Factory<Car> {

    @Override
    public Car create() {
        return new Car();
    }
    
}
