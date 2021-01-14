package com.yamhto.cloud.log.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 类描述：
 *
 * @ClassName LogConfiguration
 * @Description Log 配置
 * @Author ming.yang
 * @Date 2021/1/14 4:12 下午
 * @Version 1.0
 */
public class LogConfiguration {

    private final static Logger LOG = LoggerFactory.getLogger(LogConfiguration.class);

    @Bean
    public FrontEndInteractionLogAspect frontEndInteractionLogAspect() {
        LOG.info("Init Log Starter .....");
        return new FrontEndInteractionLogAspect();
    }
}
