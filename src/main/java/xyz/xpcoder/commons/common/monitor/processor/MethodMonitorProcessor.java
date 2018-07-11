package xyz.xpcoder.commons.common.monitor.processor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import xyz.xpcoder.commons.common.monitor.annoation.MethodMonitor;


/**
 * 注解processor
 * <p>
 * Created by laidu
 * on 2018-06-22 16:11.
 *
 * @author laidu
 */
@Slf4j(topic = "")
@Aspect
@Component
@ConditionalOnBean(LogPrintLogic.class)
public class MethodMonitorProcessor {

    @Autowired
    private ApplicationContext context;

    @Pointcut("@annotation(xyz.xpcoder.commons.common.monitor.annoation.MethodMonitor)")
    private void pointcut() {
    }

    @Around("pointcut() && @annotation(monitor)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, MethodMonitor monitor) throws Throwable {

        LogPrintLogic logPrintLogic;
        try {
            logPrintLogic = context.getBean(monitor.logic());
        }catch (Exception ex){
            log.error("未找到日志打印逻辑： {}， 将使用默认逻辑打印日志！", monitor.logic());
            logPrintLogic = context.getBean(DefaultLogPrintLogic.class);
        }
        return logPrintLogic.build(joinPoint);
    }

}