package edu.tongji.comm.design.pattern.prototype.example;

import org.junit.Test;

/**
 * @author chenkangqiang
 * @date 2017/8/30
 * @Description
 */
public class Client {

    @Test
    public void test() {
        //获取原型管理器对象
        PrototypeManager pm = PrototypeManager.getInstance();

        OfficialDocument doc1, doc2, doc3, doc4;

        System.out.println(pm.getDocuments().size());

        doc1 = pm.getOfficialDocument("FAR");
        doc1.display();
        doc2 = pm.getOfficialDocument("FAR");
        doc2.display();
        System.out.println(doc1 == doc2);

        doc3 = pm.getOfficialDocument("SRS");
        doc3.display();
        doc4 = pm.getOfficialDocument("SRS");
        doc4.display();
        System.out.println(doc3 == doc4);
    }

}
