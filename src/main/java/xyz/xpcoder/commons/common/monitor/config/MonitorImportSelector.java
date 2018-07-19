package xyz.xpcoder.commons.common.monitor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import xyz.xpcoder.commons.common.monitor.annoation.EnableMonitor;
import xyz.xpcoder.commons.common.monitor.processor.DefaultLogPrintLogic;

/**
 * monitor import
 * <p>
 * Created by laidu
 * on 2018-07-11 13:47.
 *
 * @author laidu
 */
@Slf4j
public class MonitorImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        importingClassMetadata.getAnnotationAttributes(EnableMonitor.class.getName());
        return new String[]{MonitorAutoConfigure.class.getName()};
    }
}