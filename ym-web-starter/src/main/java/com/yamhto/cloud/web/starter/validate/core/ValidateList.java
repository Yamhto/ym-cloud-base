package com.yamhto.cloud.web.starter.validate.core;

import lombok.ToString;
import lombok.experimental.Delegate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：eg：
 * @PostMapping("/saveList")
 * public Result saveList(@RequestBody @Validated(UserDTO.class) ValidationList<UserDTO> userList) {
 *     // 校验通过，才会执行业务逻辑处理
 *     return ResultBuilder.buildSuccess();
 * }
 *
 * @ClassName ValidateList
 * @Description 如果前端返回List集合，需要对里面的每一项进行校验，可以使用这个List集合进行封装
 * @Author ming.yang
 * @Date 2021/1/12 6:44 下午
 * @Version 1.0
 */
@ToString
public class ValidateList<E> implements List<E> {

    @Delegate // @Delegate是lombok注解
    @Valid // 一定要加@Valid注解
    public List<E> list = new ArrayList<>();
}
