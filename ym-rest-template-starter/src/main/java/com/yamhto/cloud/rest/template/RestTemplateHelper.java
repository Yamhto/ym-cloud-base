package com.yamhto.cloud.rest.template;

import com.yamhto.cloud.rest.template.core.BaseReq;
import com.yamhto.cloud.rest.template.core.BaseResp;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类描述：
 *
 * @ClassName RestTemplateHelper
 * @Description RestTemplateHelper
 * @Author ming.yang
 * @Date 2021/1/27 3:16 下午
 * @Version 1.0
 */
public class RestTemplateHelper<I extends BaseReq, O extends BaseResp> {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<O> invoke(String url, HttpMethod httpMethod, HttpEntity<I> httpEntity) {
        if (StringUtils.equals(httpMethod.name(), HttpMethod.GET.name())) {
            return doGet(url, httpEntity);
        } else {
            return doPost(url, httpEntity);
        }
    }

    private ResponseEntity<O> doGet(String url, HttpEntity<I> httpEntity) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        I body = httpEntity.getBody();
        List<Field> declaredFields = Collections.unmodifiableList(getExtendsFields(body));
        declaredFields.forEach(field -> {
            try {
                builder.queryParam(field.getName(), field.get(body));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return restTemplate.exchange(builder.build(true).toUri(), HttpMethod.GET, httpEntity, new ParameterizedTypeReference<O>() {
        });

    }

    private ResponseEntity<O> doPost(String url, HttpEntity<I> httpEntity) {
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<O>() {
        });
    }

    /**
     * 向上获取 继承的属性，但不超过5层，避免循环依赖造成栈溢出
     *
     * @param o
     * @return
     */
    private List<Field> getExtendsFields(Object o) {

        if (null == o) {
            return new ArrayList<>();
        }

        List<Field> fields = new ArrayList<>();
        Class clazz = o.getClass();
        int i = 0;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            if (i > 5) {
                break;
            }
            Field[] declaredFields = clazz.getDeclaredFields();
            fields.addAll(Arrays.asList(declaredFields));
            ++i;
        }

        return fields;
    }


}
