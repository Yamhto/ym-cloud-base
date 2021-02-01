package com.yamhto.cloud.web.starter.validate.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

/**
 * 类描述：jackson 配置
 *
 * @ClassName JacksonConfiguration
 * @Description jackson 配置
 * @Author ming.yang
 * @Date 2021/1/13 2:46 下午
 * @Version 1.0
 */
public class JacksonConfiguration {

    private final static Logger LOG = LoggerFactory.getLogger(JacksonConfiguration.class);

    /**
     * 默认date是使用TimeStamp，在这里默认了一个 yyyy-MM-dd HH:mm:ss 的时间模版
     *
     * @return
     */
    @Bean("jacksonObjectMapper")
    @Primary
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        LOG.info("Init Jackson Starter .....");
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        /** 为objectMapper注册一个带有SerializerModifier的Factory */
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory()
                .withSerializerModifier(new JacksonBeanSerializerModifier()));

        SerializerProvider serializerProvider = objectMapper.getSerializerProvider();
        serializerProvider.setNullValueSerializer(new CustomizeNullJacksonSerializer.NullObjectJsonSerializer());

        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }
}
