package edu.tongji.comm.design.pattern.facade;

/**
 * @author chenkangqiang
 * @date 2017/8/31
 */

/**
 * 外观类
 */
public class EncryptFacade {

    //维持对其他对象的引用
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    //调用其他对象的业务方法
    public void FileEncrypt(String infileName, String outFileName) {
        String plainStr = reader.read(infileName);
        String encryptStr = cipher.Encrypt(plainStr);
        writer.Write(encryptStr, outFileName);
    }

}
