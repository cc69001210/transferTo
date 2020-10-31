package com.zky10.mdf.transfer.util;

import cn.hutool.core.io.resource.ClassPathResource;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 11:56
 * @Description:
 */
public class FileUtil {

    private static final Long DEFAULT_START = 0L;

    /**
     * 获取上次提取的数据
     *
     * @return
     */
    public static Long getLastNumber(String fileName) {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        BufferedReader reader = classPathResource.getReader(Charset.forName("UTF-8"));
        String number = StringUtils.EMPTY;
        try {
            number = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (StringUtils.isEmpty(number) || !StringUtils.isNumeric(number)) {
            return DEFAULT_START;
        }
        return Long.parseLong(number);
    }


    public static Long resetLastNum(String fileName, Long newLastNum) {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(classPathResource.getFile());
            outputStream.write(String.valueOf(newLastNum).getBytes("UTF-8"));
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return newLastNum;
    }

    public static <T> void copyObject(ObjectOutputStream outputStream, T t) throws IOException {
        try {
            outputStream.writeObject(t);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
