package com.zky10.mdf.transfer.job;

import com.zky10.mdf.transfer.config.PropertiesConfig;
import com.zky10.mdf.transfer.config.base.BaseTransferService;
import com.zky10.mdf.transfer.pojo.TableNameEnum;
import com.zky10.mdf.transfer.pojo.constant.DataTransferConstant;
import com.zky10.mdf.transfer.service.BaseSelectService;
import com.zky10.mdf.transfer.util.FileUtil;
import com.zky10.mdf.transfer.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 11:47
 * @Description: 进行数据到文件抽取。
 */
@Component
@Slf4j
public class DataTransferToFile implements ApplicationRunner {

    @Autowired
    private BaseSelectService baseSelectService;

    @Autowired
    private ThreadPoolTaskExecutor transferExecutor;


    /**
     * 检查需要采集哪些表名
     *
     * @param tableStr
     * @return
     */
    private List<String> checkTables(String tableStr) {
        if (StringUtils.isBlank(tableStr)) {
            return Collections.emptyList();
        }
        return baseSelectService.getExistTables(Arrays.asList(tableStr.split(",")));
    }

    /**
     * 将表名抽取到文件中。使用的是对象流。
     *
     * @param existTables
     */
    public void dataTransferToFile(List<String> existTables) {
        CountDownLatch countDownLatch = new CountDownLatch(existTables.size());
        for (String tableName : existTables) {
            // 获取执行Bean，使用 线程池执行。
            BaseTransferService transferService = SpringContextUtil.getTableServiceByName(TableNameEnum.getInstanceByName(tableName));
            if (transferService == null) {
                continue;
            }
            transferExecutor.execute(() -> {
                try {
                    transferService.transferToFile(tableName);
                } catch (Exception e) {
                    log.error("数据处理过程中发生异常：{}", e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        try {
            log.info("多线程抽取数据执行中。。。请等待。。。。");
            countDownLatch.await();
        } catch (Exception e) {
            log.error("线程等待发生异常。。。。{}", e.getMessage(), e);
        }

        log.info("【WARN】===== 数据抽取已经完成。。");
        log.info("【WARN】===== 数据抽取已经完成。。");
        log.info("【WARN】===== 数据抽取已经完成。。");
        log.info("【WARN】===== 数据抽取已经完成。。");
        log.info("【WARN】===== 数据抽取已经完成。。");
        transferExecutor.shutdown();

        throw new RuntimeException("【数据抽取完成=========== 】手动强制停止所有线程线程！！");
    }


    @Override
    public void run(ApplicationArguments args) {
        // 初始化数据，配置文件，运行目录等
        initPath(PropertiesConfig.getProperty("conf.dir"));
        // 获取要传输的表
        String tableStr = PropertiesConfig.getProperty("tables");
        log.info("======== 要传输的表为：{}", tableStr);
        // 对标进行校验
        List<String> tables = checkTables(tableStr);
        // 传输数据
        dataTransferToFile(tables);
    }

    /**
     * 初始化文件目录
     *
     * @param baseDir
     */
    private void initPath(String baseDir) {
        // 创建 数据存放 目录
        String dataDirPath = baseDir + File.separator + DataTransferConstant.DATA_DIR_NAME;
        FileUtil.createFile(dataDirPath);
        // 创建 记录存放 目录
        String recordDirPath = baseDir + File.separator + DataTransferConstant.RECORD_DIR_NAME;
        FileUtil.createFile(recordDirPath);
    }
}
