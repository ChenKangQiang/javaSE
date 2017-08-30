package edu.tongji.comm.design.pattern.prototype;

import org.junit.Test;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */


public class Client {

    @Test
    public void testPrototype() {
        WeeklyLog log_previous = new WeeklyLog();  //创建原型对象
        log_previous.setName("张无忌");
        log_previous.setDate("第12周");
        log_previous.setContent("这周工作很忙，每天加班！");

        System.out.println("****周报****");
        System.out.println("周次：" + log_previous.getDate());
        System.out.println("姓名：" + log_previous.getName());
        System.out.println("内容：" + log_previous.getContent());
        System.out.println("--------------------------------");

        WeeklyLog log_new = null;
        try {
            log_new = (WeeklyLog) log_previous.clone(); //调用克隆方法创建克隆对象
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (log_new != null) {
            log_new.setDate("第13周");
            System.out.println("****周报****");
            System.out.println("周次：" + log_new.getDate());
            System.out.println("姓名：" + log_new.getName());
            System.out.println("内容：" + log_new.getContent());
        }
    }


    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        WeeklyLog log_previous, log_new;
        log_previous = new WeeklyLog(); //创建原型对象
        Attachment attachment = new Attachment(); //创建附件对象
        log_previous.setAttachment(attachment);  //将附件添加到周报中
        log_new = (WeeklyLog) log_previous.clone(); //调用克隆方法创建克隆对象
        //比较周报
        System.out.println("周报是否相同？ " + (log_previous == log_new));
        //比较附件
        System.out.println("附件是否相同？ " + (log_previous.getAttachment() == log_new.getAttachment()));
    }


}
