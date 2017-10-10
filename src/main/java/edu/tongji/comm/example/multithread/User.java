package edu.tongji.comm.example.multithread;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author chenkangqiang
 * @Data 2017/9/23
 *
 * POJO
 */

@Data
public class User {

    private String name;
    private String email;

    private static User instance = new User();

    private User() {

    }

    public static User getInstance() {
        return instance;
    }

}
