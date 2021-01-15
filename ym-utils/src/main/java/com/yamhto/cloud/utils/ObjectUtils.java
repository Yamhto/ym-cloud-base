package com.yamhto.cloud.utils;

/**
 * 类描述：
 *
 * @ClassName ObjectUtils
 * @Description ObjectUtils
 * @Author ming.yang
 * @Date 2021/1/15 10:20 上午
 * @Version 1.0
 */
public class ObjectUtils {

    public static boolean isPrimitive(Class clazz) {
        return clazz.isPrimitive() || clazz == String.class;
    }

    public static boolean isPrimitive(Object obj) {
        return isPrimitive(obj.getClass());
    }


}
