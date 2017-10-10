package edu.tongji.comm.example.servlet.spring;

import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * @author chenkangqiang
 * @date 2017/9/29
 */

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public String execute() {
        try {
            Thread.sleep(5000);
            return "Task finished";
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

}
