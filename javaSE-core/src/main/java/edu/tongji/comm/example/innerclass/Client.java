package edu.tongji.comm.example.innerclass;

import org.junit.Test;
import edu.tongji.comm.example.innerclass.Outer.Inner;
import edu.tongji.comm.example.innerclass.Watcher.Event.KeeperState;
import edu.tongji.comm.example.innerclass.Watcher.Event.EventType;


/**
 * @author chenkangqiang
 * @date 2017/9/11
 */

public class Client {

    @Test
    public void test() {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner);
    }


    @Test
    public void test2() {
        OuterWithStaticInner.Inner inner = new OuterWithStaticInner.Inner();
        OuterWithStaticInner.Code type = OuterWithStaticInner.Code.TYPE_A;
        System.out.println(inner);
    }


    public void test3() {
        KeeperState state = KeeperState.Disconnected;
    }


}
