package com.yamhto.cloud.web.starter.validate;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 类描述：
 *
 * @ClassName EnableValidate
 * @Description 开启 spring validate 注解
 * @Author ming.yang
 * @Date 2021/1/12 3:57 下午
 * @Version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SpringValidateConfiguration.class})
public @interface EnableValidate {


}
