package edu.tongji.comm.example.innerclass;

/**
 * @Author chenkangqiang
 * @Data 2017/10/16
 */
public interface Watcher {

    public static interface Event {


        public static enum KeeperState {

            Disconnected,
            SyncConnected;

        }


        public static enum EventType {
            NodeCreadted,
            NodeDeleted;
        }


        public static class Inner {

        }

    }

}
