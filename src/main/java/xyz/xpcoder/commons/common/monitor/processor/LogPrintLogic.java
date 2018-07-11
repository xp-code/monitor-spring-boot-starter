package xyz.xpcoder.commons.common.monitor.processor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志打印逻辑
 * <p>
 * Created by laidu
 * on 2018-07-10 15:50.
 *
 * @author laidu
 */
@FunctionalInterface
public interface LogPrintLogic {
    Object build(ProceedingJoinPoint joinPoint) throws Throwable;
}