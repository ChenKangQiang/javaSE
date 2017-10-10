package edu.tongji.comm.example.job;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author chenkangqiang
 * @date 2017/9/28
 */
public class HelloQuartzSchedule {

    public static void main(String[] args)throws SchedulerException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(HelloQuartzJob.class)
                .withIdentity("helloQuartzJob", Scheduler.DEFAULT_GROUP)
                .build();

        //简单触发器
        SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                .withIdentity("helloTrigger", Scheduler.DEFAULT_GROUP)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .build();

        //任务触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("helloCronTrigger", Scheduler.DEFAULT_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule("*/1 * * * * ?"))
                .build();

        scheduler.scheduleJob(jobDetail, simpleTrigger);

        //调度器启动后会开辟一个线程
        scheduler.start();

        System.out.println("main");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }
}
