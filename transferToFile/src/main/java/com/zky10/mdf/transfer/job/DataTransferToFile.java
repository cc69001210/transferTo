package com.zky10.mdf.transfer.job;

import com.zky10.mdf.transfer.config.PropertiesConfig;
import com.zky10.mdf.transfer.config.base.BaseTransferService;
import com.zky10.mdf.transfer.pojo.TableNameEnum;
import com.zky10.mdf.transfer.service.BaseSelectService;
import com.zky10.mdf.transfer.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @company: 北京一零科技
 * @program: transfer
 * @author: cc
 * @Date: 2020-10-30 11:47
 * @Description:
 */
@Component
@Slf4j
public class DataTransferToFile implements ApplicationRunner {

    @Autowired
    private BaseSelectService baseSelectService;

    @Autowired
    private ThreadPoolTaskExecutor transferExecutor;


    private List<String> checkTables(String tableStr) {
        if (StringUtils.isBlank(tableStr)) {
            return Collections.emptyList();
        }
        return baseSelectService.getExistTables(Arrays.asList(tableStr.split(",")));
    }

    public void dataTransferToFile(List<String> existTables) {
        CountDownLatch countDownLatch = new CountDownLatch(existTables.size());
        for (String table : existTables) {
            // 获取执行Bean，使用 线程池执行。
            BaseTransferService transferService = SpringContextUtil.getTableServiceByName(TableNameEnum.getInstanceByName(table));
            if (transferService == null) {
                continue;
            }
            transferExecutor.execute(()-> {
                try {
                    transferService.transferToFile();
                } catch (Exception e) {

                } finally {
                    countDownLatch.countDown();
                }
            });

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
    }

    @Override
    public void run(ApplicationArguments args) {
        // 获取要传输的表
        String tableStr = PropertiesConfig.getProperty("tables");
        log.info("======== 要传输的表为：{}", tableStr);
        // 对标进行校验
        List<String> tables = checkTables(tableStr);
        // 传输数据
        dataTransferToFile(tables);
    }
}
