package edu.tongji.comm.example.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author chenkangqiang
 * @date 2017/9/28
 *
 * job：定义任务的实际内容
 */
public class HelloQuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello, Quartz! - executing its JOB at "+ new Date());
    }

}
