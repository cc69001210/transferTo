package com.zky10.mdf.transfer.util;

import com.zky10.mdf.transfer.config.base.BaseTransferService;
import com.zky10.mdf.transfer.pojo.TableNameEnum;
import com.zky10.mdf.transfer.service.BdHyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-10-31 11:24
 * @Description: 获取Soring中的Bean
 */
@Configuration
@Slf4j
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("设置APPLICATION_CONTEXT 成功。。");
        this.APPLICATION_CONTEXT = applicationContext;
    }

    public static BaseTransferService getTableServiceByName(TableNameEnum tableName) {
        switch (tableName) {
            case BD_HY:
                return APPLICATION_CONTEXT.getBean(BdHyService.class);
            default:
                return null;
        }
    }

}
