package com.yamhto.cloud.log.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yamhto.cloud.jackson.starter.JacksonHelper;
import com.yamhto.cloud.utils.HttpUtils;
import com.yamhto.cloud.utils.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述：前后端交互日志 切面
 *
 * @ClassName FrontEndInteractionLogAspect
 * @Description 前后端交互日志 切面
 * @Author ming.yang
 * @Date 2021/1/14 3:57 下午
 * @Version 1.0
 */
@Aspect
public class FrontEndInteractionLogAspect {

    private final static Logger LOG = LoggerFactory.getLogger(FrontEndInteractionLogAspect.class);

    public static final String COMMA = ",";

    public static final String ARG = "ARG";

    public static final String COLONS = ":";

    @Pointcut(value = "@annotation(com.yamhto.cloud.log.starter.Log)")
    public void pointcut() {
    }


    /**
     * 在进入controller之前拦截并打印请求报文日志
     *
     * @param joinPoint
     * @param log
     * @throws JsonProcessingException
     */
    @Before("pointcut()&& @annotation(log)")
    public void printRequestDatagram(JoinPoint joinPoint, Log log) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = HttpUtils.getIpAddress(request);
        Object[] args = joinPoint.getArgs();
        List<Object> argList = Arrays.asList(args);

        StringBuilder sb = new StringBuilder();

        sb.append("\n ==> 请求者IP：").append(ip)
                .append("\n ==> 请求接口：").append(request.getMethod());

        if (!CollectionUtils.isEmpty(argList)) {
            sb.append("\n ==> 请求报文：");
            for (int i = 0, argListSize = argList.size(); i < argListSize; i++) {
                Object arg = argList.get(i);
                if (ObjectUtils.isPrimitive(arg)) {
                    sb.append(ARG).append(i).append(COLONS).append(arg);
                    if (i != argList.size() - 1) {
                        sb.append(COMMA);
                    }
                } else {
                    sb.append(ARG).append(i).append(COLONS).append(JacksonHelper.generate(arg));
                    if (i != argList.size() - 1) {
                        sb.append(COMMA);
                    }
                }
            }
        }

        LOG.info(sb.toString());
    }


    /**
     * 返回信息后，打印应答报文的日志
     *
     * @param joinPoint
     * @param log
     * @return
     * @throws Throwable
     */
    @Around(value = "pointcut() && @annotation(log)")
    public Object printResponseDatagram(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
        Object res = joinPoint.proceed();

        if (res.getClass().isPrimitive() || (res instanceof String)) {
            LOG.info("\n <== 响应报文：{}", res);
        } else {
            LOG.info("\n <== 响应报文：{}", JacksonHelper.generate(res));

        }

        return res;
    }

}
