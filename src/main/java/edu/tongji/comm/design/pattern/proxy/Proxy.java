package edu.tongji.comm.design.pattern.proxy;

/**
 * @author chenkangqiang
 * @date 2017/9/1
 */

public class Proxy implements Searcher {

    /**
     * 维持对目标对象的引用
     */
    private Searcher searcher;

    private AccessValidator accessValidator;


    @Override
    public String doSearch(Integer userId, String key) {
        accessValidator.validate(userId);
        return searcher.doSearch(userId, key);
    }

}
