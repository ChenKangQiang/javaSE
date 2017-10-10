package edu.tongji.comm.example.multithread.singletonperthreadV2;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 */

@Data
public class Car {
    private String name;
    private String price;

    public Car() {

    }
}
