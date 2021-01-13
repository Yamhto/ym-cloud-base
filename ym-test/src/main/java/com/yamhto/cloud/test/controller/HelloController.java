package com.yamhto.cloud.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yamhto.cloud.jackson.starter.JacksonHelper;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private JacksonHelper jacksonHelper;

    @GetMapping("hello")
    public String hello(@RequestParam(value = "length", required = false)
                        @NotBlank @Length(min = 6, max = 12) String length) {
        return "Hello World !!" + length;
    }

    @PostMapping("model")
    public String model(@RequestBody @Valid Model model) {
        try {
            return jacksonHelper.generate(model);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
