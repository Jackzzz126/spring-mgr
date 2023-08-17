package com.jack.mgr.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * LogUmpAspect
 *
 * @author zhengzhe17
 * @date 2023/8/16
 */
@Slf4j
@Aspect
@Component
public class MgrLogAspect {
    /**
     * 方法执行后添加log
     *
     * @param joinPoint 切点
     */
    @Around("@annotation(mgrLogHandler)")
    public Object around(ProceedingJoinPoint joinPoint, MgrLogHandler mgrLogHandler) throws Throwable {
        String paramIn = "";
        Object result = null;
        // 设置方法名称
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String name = className + "." + methodName;

        // 入参
        if (joinPoint.getArgs().length > 0) {
            paramIn = Arrays.stream(joinPoint.getArgs()).filter(Objects::nonNull).map(Object::toString).collect(Collectors.toList()).toString();
        }
        long start = System.currentTimeMillis();
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            if (mgrLogHandler.printLog()) {
                log.info(name + " cost:" + (System.currentTimeMillis() - start) + "ms, in=>" + paramIn + "out=>" + result);
            }
        } catch (Throwable e) {
            log.error(name + " exception  cost:" + (System.currentTimeMillis() - start) + "ms, in=>" + paramIn + "out=>" + result, e);
            throw e;
        }
        return result;
    }
}
