package xyz.xpcoder.commons.common.monitor.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.AliasFor;
import xyz.xpcoder.commons.common.monitor.annoation.EnableMonitor;

/**
 * Created by laidu
 * on 2018-07-10 15:48.
 *
 * @author laidu
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConditionalOnBean(MonitorImportSelector.class)
@ConfigurationProperties(prefix="monitor")
public class MonitorProperties {

    /**
     * 项目名
     */
    private String projectName = "app";

    /**
     * 日志文件路径
     */
    private String logFile = "logs/"+projectName+"-monitor.log";

    /**
     * 日志级别
     */
    private String loglevel = "info";

    /**
     * uuid key
     */
    private String uuidName = "uuid";


}