package edu.tongji.comm.design.pattern.facade;

import java.io.File;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */
public class FileWriter {

    public void Write(String encryptStr, String fileName) {
        System.out.println("保存密文，写入文件。");
        try {
            File file = new File(fileName);
            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            fileWriter.write(encryptStr);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
