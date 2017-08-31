package edu.tongji.comm.design.pattern.facade;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */

/**
 * 加密类
 */
public class CipherMachine {

    public String Encrypt(String plainText)
    {
        System.out.println("数据加密，将明文转换为密文：");
        String es = "";
        char[] chars = plainText.toCharArray();
        for (char ch : chars) {
            String c = ((Integer)(ch % 7)).toString();
            es += c;
        }
        return es;
    }
}
