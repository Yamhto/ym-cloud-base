package com.yamhto.cloud.web.starter.validate.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 类描述：spring mvc 使用 jackson 序列化 配置类
 *
 * @ClassName WebMvcJacksonSerializerConfiguration
 * @Description spring mvc 使用 jackson 序列化 配置类
 * @Author ming.yang
 * @Date 2021/1/14 5:08 下午
 * @Version 1.0
 */
public class WebMvcJacksonSerializerConfiguration {

    private final static Logger LOG = LoggerFactory.getLogger(WebMvcJacksonSerializerConfiguration.class);

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(@Qualifier("jacksonObjectMapper") ObjectMapper objectMapper) {
        LOG.info("web mvc 使用 jackson 序列化 配置");
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
