package com.yamhto.cloud.web.starter.validate.core;

import com.yamhto.cloud.web.starter.validate.ValidateEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;


/**
 * 类描述：参数为枚举值时的校验
 *
 * @ClassName EnumValueValidator
 * @Description 参数为枚举值时的校验
 * @Author ming.yang
 * @Date 2021/1/12 6:57 下午
 * @Version 1.0
 */
public class EnumValueValidator implements ConstraintValidator<ValidateEnum, Object> {

    private String[] strValues;

    private int[] intValues;

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (value instanceof String) {
            return Arrays.asList(strValues).contains(value);

        } else if (value instanceof Integer) {
            return Arrays.stream(intValues).anyMatch(val -> val == (int) value);
        }
        return false;
    }

    @Override
    public void initialize(ValidateEnum constraintAnnotation) {
        this.intValues = constraintAnnotation.intValues();
        this.strValues = constraintAnnotation.strValues();
    }
}
