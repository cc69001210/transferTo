package com.zky10.mdf.transfer.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

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
}
