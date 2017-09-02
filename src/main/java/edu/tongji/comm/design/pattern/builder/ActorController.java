package edu.tongji.comm.design.pattern.builder;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 * @Description
 */

/**
 * 指挥者
 */
public class ActorController {

    public static Actor construct(ActorBuilder ab) {
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        return ab.createActor();
    }
}
