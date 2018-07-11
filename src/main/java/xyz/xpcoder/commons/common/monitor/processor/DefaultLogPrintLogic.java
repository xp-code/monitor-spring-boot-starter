package xyz.xpcoder.commons.common.monitor.processor;

import com.alibaba.fastjson.JSON;
import jodd.exception.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.util.StopWatch;
import xyz.xpcoder.commons.common.monitor.config.MonitorAutoConfigure;
import xyz.xpcoder.commons.common.monitor.model.MonitorBaseData;

import java.util.Optional;

/**
 * Created by laidu
 * on 2018-07-10 15:53.
 *
 * @author laidu
 */

@Slf4j
@ConditionalOnClass({MonitorAutoConfigure.class})
public class DefaultLogPrintLogic implements LogPrintLogic {

    @Override
    public Object build(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch watch = new StopWatch();
        Object proceed = null;
        MonitorBaseData data = new MonitorBaseData();

        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();


        StringBuilder argsString = new StringBuilder();

        for (int i = 0; i < codeSignature.getParameterNames().length; i++) {

            Object arg = joinPoint.getArgs()[i];
            argsString
                    .append(codeSignature.getParameterNames()[i])
                    .append(" : ")
                    .append(arg.getClass().isPrimitive() ? String.valueOf(arg) : JSON.toJSONString(arg))
                    .append("; ");
        }

        data.setArgs(argsString.toString());

        watch.start();

        try {
            proceed = joinPoint.proceed();

            Optional.ofNullable(proceed)
                    .ifPresent(proceed1 -> data.setResult(proceed1.getClass().isPrimitive() ? String.valueOf(proceed1) : JSON.toJSONString(proceed1)));

            data.setSuccess(true);
            data.setElapsedTime(watch.getTotalTimeMillis());
            data.setMethodSignature(joinPoint.getSignature().toLongString());

        } catch (Exception ex) {
            data.setExceptionClass(ex.getClass().getTypeName());
            data.setExceptionStackTrace(ExceptionUtil.exceptionStackTraceToString(ex));
            throw ex;
        } finally {
            watch.stop();
            data.setElapsedTime(watch.getTotalTimeMillis());
            log.warn("{} with args {} executed in {} ms", joinPoint.getSignature(), joinPoint.getArgs(), watch.getTotalTimeMillis());

            log.info("data: {}", data);
        }

        return proceed;
    }
}