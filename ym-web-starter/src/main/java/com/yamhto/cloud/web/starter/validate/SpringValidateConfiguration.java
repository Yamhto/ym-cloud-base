package com.yamhto.cloud.web.starter.validate;

import com.yamhto.cloud.web.starter.validate.core.EnumValueValidator;
import com.yamhto.cloud.web.starter.validate.core.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 类描述：spring validate 配置
 *
 * @ClassName SpringValidateConfiguration
 * @Description spring validate 配置
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

    @Bean
    public EnumValueValidator enumValueValidator() {
        return new EnumValueValidator();
    }
}
