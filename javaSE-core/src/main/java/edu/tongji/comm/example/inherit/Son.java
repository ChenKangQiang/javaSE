package edu.tongji.comm.example.inherit;

import lombok.Data;

/**
 * @author chenkangqiang
 * @date 2017/9/6
 */

@Data
public class Son extends Father {

    private int score = 100;
    private int age = 10;

//    @Override
//    public int getAge() {
//        return this.score;
//    }

}
