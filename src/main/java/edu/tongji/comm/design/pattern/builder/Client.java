package edu.tongji.comm.design.pattern.builder;

import org.junit.Test;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */
public class Client {

    @Test
    public void test() {
        ActorBuilder heroBuilder = new HeroBuilder();
        Actor actor = ActorController.construct(heroBuilder);
        System.out.println(actor);
    }

}
