package com.yamhto.cloud.log.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yamhto.cloud.jackson.starter.JacksonHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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
    public void printRequestDatagram(JoinPoint joinPoint, Log log) throws JsonProcessingException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = HttpUtils.getIpAddress(request);
        Object[] args = joinPoint.getArgs();

        LOG.info(String.format("\n ==> 请求者IP：%s \n ==> 请求接口：%s %s \n ==> 请求报文：%s",
                ip, request.getMethod(),
                request.getRequestURL(),
                args[0].getClass().isPrimitive() ? args[0] : JacksonHelper.generate(args[0])));
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
    public Object authenticate(ProceedingJoinPoint joinPoint, Log log) throws Throwable {
        Object res = joinPoint.proceed();

        if (res.getClass().isPrimitive() || (res instanceof String)) {
            LOG.info("\n <== 响应报文：{}", res);
        } else {
            try {
                LOG.info("\n <== 响应报文：{}", JacksonHelper.generate(res));
            } catch (JsonProcessingException e) {
                LOG.error("jackson 转 String 出错", e);
            }
        }

        return res;
    }

}
