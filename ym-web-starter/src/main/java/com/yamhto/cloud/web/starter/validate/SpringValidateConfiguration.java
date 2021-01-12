package com.yamhto.cloud.web.starter.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 类描述：
 *
 * @ClassName SpringValidateConfiguration
 * @Description TODO
 * @Author ming.yang
 * @Date 2021/1/12 3:58 下午
 * @Version 1.0
 */
public class SpringValidateConfiguration {

    private static Logger LOG = LoggerFactory.getLogger(SpringValidateConfiguration.class);

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        LOG.info("Init Spring Validate Starter");
        return new GlobalExceptionHandler();
    }
}
