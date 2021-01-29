package com.yamhto.cloud.mybatis.plus;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 类描述：
 *
 * @ClassName EnableDynamicDataSource
 * @Description EnableDynamicDataSource
 * @Author ming.yang
 * @Date 2021/1/29 4:11 下午
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicDataSourceAutoConfiguration.class)
public @interface EnableDynamicDataSource {
}
