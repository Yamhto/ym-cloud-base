package com.yamhto.cloud.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类描述：
 *
 * @ClassName HelloController
 * @Description hello
 * @Author ming.yang
 * @Date 2021/1/12 2:21 下午
 * @Version 1.0
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        return "Hello World !!";
    }
}
