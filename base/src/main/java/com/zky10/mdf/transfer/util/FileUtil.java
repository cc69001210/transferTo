package com.zky10.mdf.transfer.util;

import com.zky10.mdf.transfer.config.PropertiesConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 11:56
 * @Description:
 */
@Slf4j
public class FileUtil {

    public static final Long DEFAULT_START = 0L;
    public static final String LAST_RECORD_SUFFIX = ".last";
    public static final String DB_DATA_SUFFIX = ".data";

    /**
     * 获取上次提取到的id
     *
     * @return
     */
    public static Long getLastNumberByFilePath(String filePath) {
        BufferedReader reader = null;
        String number = StringUtils.EMPTY;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            number = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (StringUtils.isEmpty(number) || !StringUtils.isNumeric(number)) {
            return DEFAULT_START;
        }
        return Long.parseLong(number);
    }


    /**
     * 重设 lastNum
     *
     * @param filePath
     * @param newLastNum
     * @return
     */
    public static Long resetLastNumByFilePath(String filePath, Long newLastNum) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
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

    /**
     * 获取上次提取到的id
     *
     * @return
     */
    public static Long getLastNumberByTableName(String tableName) {
        return getLastNumberByFilePath(getFileRecordPathByTableName(tableName));
    }

    /**
     * 根据表名 重设 lastNum
     *
     * @param tableName
     * @param newLastNum
     * @return
     */
    public static Long resetLastNumByTableName(String tableName, Long newLastNum) {
        return resetLastNumByFilePath(getFileRecordPathByTableName(tableName), newLastNum);
    }

    /**
     * 根据表名获取文件路径。
     *
     * @param tableName 表名
     * @return
     */
    public static String getFileRecordPathByTableName(String tableName) {
        String property = PropertiesConfig.getProperty("tables.record.path");
        property = property.replace("/", File.separator).replace("\\", File.separator);
        String filePath = property + File.separator + tableName + LAST_RECORD_SUFFIX;
        initFile(filePath);
        return filePath;
    }

    private static void initFile(String filePath) {
        File file = new File(filePath);
        // 父级目录
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 创建文件
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("初始化 file失败====={}", e.getMessage(), e);
            }
        }
    }

    /**
     * 根据表名获取文件路径。
     *
     * @param tableName 表名
     * @return
     */
    public static String getFileDataPathByTableName(String tableName) {
        String property = PropertiesConfig.getProperty("tables.data.path");
        property = property.replace("/", File.separator).replace("\\", File.separator);
        String filePath = property + File.separator + tableName + DB_DATA_SUFFIX;
        initFile(filePath);
        return filePath;
    }

    /**
     * 进行 Object对象流输入。
     *
     * @param outputStream
     * @param t
     * @param <T>
     * @throws IOException
     */
    public static <T> void copyObject(ObjectOutputStream outputStream, T t) {
        try {
            outputStream.writeObject(t);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("写入对象流失败，详细信息：{}", e.getMessage(), e);
        }
    }


}
