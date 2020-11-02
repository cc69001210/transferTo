package com.zky10.mdf.transfer.config;

import java.io.*;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 15:19
 * @Description:
 */
public class MyObjectInputStream extends ObjectInputStream {

    public MyObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() throws IOException, StreamCorruptedException {
    }



    /**
     * 获取指向指定文件的 输入流
     * @param fileName
     * @return
     * @throws IOException
     */
    public static MyObjectInputStream newInstance(String fileName) throws IOException {
        return new MyObjectInputStream(new FileInputStream(fileName));
    }
}
