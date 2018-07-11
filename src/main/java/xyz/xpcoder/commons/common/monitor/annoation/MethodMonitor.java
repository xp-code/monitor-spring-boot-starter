package xyz.xpcoder.commons.common.monitor.annoation;


import java.lang.annotation.*;

import xyz.xpcoder.commons.common.monitor.processor.DefaultLogPrintLogic;
import xyz.xpcoder.commons.common.monitor.processor.LogPrintLogic;

/**
 * 方法执行 monitor
 * <p>
 * Created by laidu
 * on 2018-06-22 16:07.
 *
 * @author laidu
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodMonitor {

    /**
     * 日志打印 逻辑
     *
     */
    Class<? extends LogPrintLogic> logic() default DefaultLogPrintLogic.class;

    String value() default "";

    /**
     * 日志路径
     * @return 日志路径
     */
    String logFile() default "";


}
