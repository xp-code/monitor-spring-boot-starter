package xyz.xpcoder.commons.common.monitor.annoation;


import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;
import xyz.xpcoder.commons.common.monitor.config.MonitorImportSelector;

import java.lang.annotation.*;

/**
 * 启用监控
 * <p>
 * Created by laidu
 * on 2018-07-10 15:59.
 *
 * @author laidu
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AutoConfigurationPackage
@Import(MonitorImportSelector.class)
public @interface EnableMonitor {
    String value() default  "";
}
