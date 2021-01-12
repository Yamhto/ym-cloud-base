package com.yamhto.cloud.test.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

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
@Validated
public class HelloController {

    @GetMapping("hello")
    public String hello(@RequestParam(value = "length", required = false)
                        @NotBlank @Length(min = 6, max = 12) String length) {
        return "Hello World !!" + length;
    }
}