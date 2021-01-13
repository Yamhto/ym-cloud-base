package com.yamhto.cloud.jackson.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 类描述：JacksonHelper jackson 工具类
 *
 * @ClassName JacksonHelper
 * @Description JacksonHelper jackson 工具类
 * @Author ming.yang
 * @Date 2021/1/13 2:26 下午
 * @Version 1.0
 */
public class JacksonHelper {

    @Autowired
    private ObjectMapper mapper;

    private JacksonHelper() {
    }

    /**
     * Serialize any Java value as a String.
     */
    public String generate(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    /**
     * Deserialize JSON content from given JSON content String.
     */
    public <T> T parse(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }
}
