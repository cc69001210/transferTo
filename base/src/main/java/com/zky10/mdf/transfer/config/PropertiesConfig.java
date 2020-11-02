package com.zky10.mdf.transfer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-10-31 09:59
 * @Description:
 */
@Configuration
@PropertySources({
        @PropertySource(value = "file:${conf.dir}/conf/config.properties"),
})
@Slf4j
public class PropertiesConfig implements EnvironmentAware {

    private static Environment ENVIRONMENT;

    @Override
    public void setEnvironment(Environment environment) {
        log.info("初始化 ENVIRONMENT 开始。。。。");
        this.ENVIRONMENT = environment;
        log.info("初始化 ENVIRONMENT 结束。。。。");
    }

    /**
     * 根据 参数名获取参数
     * @param propertyName
     * @return
     */
    public static String getProperty(String propertyName) {
        return ENVIRONMENT.getProperty(propertyName);
    }


}
