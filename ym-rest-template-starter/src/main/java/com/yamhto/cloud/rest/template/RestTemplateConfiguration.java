package com.yamhto.cloud.rest.template;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 类描述：
 *
 * @ClassName RestTemplateConfiguration
 * @Description RestTemplate config
 * @Author ming.yang
 * @Date 2021/1/27 2:33 下午
 * @Version 1.0
 */
public class RestTemplateConfiguration {


    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());

        factory.setConnectTimeout(6000);
        factory.setReadTimeout(6000);

        return new RestTemplate(factory);
    }

    @Bean
    public RestTemplateHelper restTemplateHelper() {
        return new RestTemplateHelper<>();
    }

}
