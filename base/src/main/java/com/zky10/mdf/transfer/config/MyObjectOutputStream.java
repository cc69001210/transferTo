package com.zky10.mdf.transfer.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 15:19
 * @Description: 自定义OutputStream, 对象流输出的时候，每次添加一个对象都会添加一个对象头，解析的时候会报错。
 */
public class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MyObjectOutputStream() throws IOException, SecurityException {

    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // 将每次添加对象头的操作去掉，每次不添加。解析的时候也不需要读取了。
    }

    public static MyObjectOutputStream newInstance(String fileName) throws IOException {
        return new MyObjectOutputStream(new FileOutputStream(fileName));
    }
}
