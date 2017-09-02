package edu.tongji.comm.design.pattern.facade;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */

import java.io.*;

/**
 * 文件读取类
 */
public class FileReader {

    public String read(String fileName) {
        System.out.println("读取文件，获取明文");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(fileName)));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.readLine() != null) {
                stringBuilder.append(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件操作错误");
        }
        return stringBuilder.toString();
    }
}
