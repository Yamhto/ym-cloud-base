package com.yamhto.cloud.mybatis.plus.core;

import com.baomidou.dynamic.datasource.annotation.DS;

import java.lang.annotation.*;

/**
 * 类描述：
 *
 * @ClassName Product
 * @Description 生产数据源
 * @Author ming.yang
 * @Date 2021/1/29 11:40 上午
 * @Version 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DS("product")
public @interface Product {
}
