package com.zky10.mdf.transfer.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-11-16 11:22
 * @Description: 文件操作工具类
 */
@Slf4j
public class FileUtil {

    /**
     * 创建文件
     *
     * @param filePath
     */
    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory() && !file.exists()) {
            file.mkdirs();
            log.info("创建文件夹： == {} ===  成功", filePath);
        } else {
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
                    log.error("创建 file失败，创建路径为：{}，原因 ====={}", filePath, e.getMessage(), e);
                }
            }
        }
    }

    public static void createAndMoveFile(String fileDataPath, String fileDestPath) {
        File file = new File(fileDataPath);
        if (file.exists()) {
            moveFile(fileDataPath, fileDestPath);
        } else {
            createFile(fileDataPath);
        }

    }

    private static void moveFile(String fileDataPath, String fileDestPath) {
        cn.hutool.core.io.FileUtil.move(new File(fileDataPath), new File(fileDestPath), true);
    }
}
