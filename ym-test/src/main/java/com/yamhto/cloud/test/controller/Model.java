package com.yamhto.cloud.test.controller;

import com.yamhto.cloud.web.starter.validate.ValidateEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 类描述：
 *
 * @ClassName Model
 * @Description Model
 * @Author ming.yang
 * @Date 2021/1/12 7:10 下午
 * @Version 1.0
 */
@Getter
@Setter
public class Model {

    @Length(min = 3, max = 12)
    private String name;

    @ValidateEnum(intValues = {1, 2}, message = "1:MAN ---- 2:WOMAN")
    private int sex;

    private Date birth;

}
