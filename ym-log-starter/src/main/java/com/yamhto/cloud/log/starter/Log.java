package com.yamhto.cloud.log.starter;

import java.lang.annotation.*;

/**
 * 类描述：
 *
 * @ClassName Log
 * @Description Log 注解，打印日志使用
 * @Author ming.yang
 * @Date 2021/1/14 3:45 下午
 * @Version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
