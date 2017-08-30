package edu.tongji.comm.design.pattern.prototype;

import lombok.Data;

/**
 * @author chenkangqiang
 * @date 2017/8/29
 * @Description
 */

@Data
public class Attachment {
    /**
     * 附件名
     */
    private  String name;

    public void download()
    {
        System.out.println("下载附件，文件名为" + name);
    }
}
