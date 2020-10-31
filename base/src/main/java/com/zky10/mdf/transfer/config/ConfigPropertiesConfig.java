package com.zky10.mdf.transfer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @company: 北京一零科技
 * @program: transferTo
 * @author: cc
 * @Date: 2020-10-31 09:59
 * @Description:
 */
@Configuration
@PropertySource(value = "file:${conf.dir}/conf/config.properties")
public class ConfigPropertiesConfig {



}
