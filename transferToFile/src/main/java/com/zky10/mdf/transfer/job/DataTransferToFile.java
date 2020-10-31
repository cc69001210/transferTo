package com.zky10.mdf.transfer.job;

import com.zky10.mdf.transfer.config.base.BaseTransferService;
import com.zky10.mdf.transfer.pojo.TableNameEnum;
import com.zky10.mdf.transfer.service.BaseSelectService;
import com.zky10.mdf.transfer.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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
public class DataTransferToFile {

    @Autowired
    private Environment environment;

    @Autowired
    private BaseSelectService baseSelectService;

    @Autowired
    private ThreadPoolTaskExecutor transferExecutor;

    @PostConstruct
    public void init() {
        // 获取要传输的表
        String tableStr = environment.getProperty("tables");
        log.info("======== 要传输的表为：{}", tableStr);
        // 对标进行校验
        List<String> tables = checkTables(tableStr);
        // 传输数据
        dataTransferToFile(tables);
    }

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

            transferExecutor.shutdown();
        }
    }

}
