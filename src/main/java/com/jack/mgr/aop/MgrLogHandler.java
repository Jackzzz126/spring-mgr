package com.jack.mgr.aop;

import java.lang.annotation.*;

/**
 * ServiceHandler
 *
 * @author zhengzhe17
 * @date 2023/8/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MgrLogHandler {
    /**
     * 业务名称
     */
    String value() default "";

    /**
     * 是否打印日志
     */
    boolean printLog() default true;
}
