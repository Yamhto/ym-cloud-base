package com.yamhto.cloud.jackson.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

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

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    private JacksonHelper() {
    }

    /**
     * Serialize any Java value as a String.
     */
    public static String generate(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    /**
     * Deserialize JSON content from given JSON content String.
     */
    public static <T> T parse(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }
}
