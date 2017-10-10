package edu.tongji.comm.example.multithread;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author chenkangqiang
 * @Data 2017/10/10
 */

@Setter
@Getter
public class Connection {
    private String username;
    private String password;
    private String port;
    private String url;
}
