package xyz.xpcoder.commons.common.monitor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import xyz.xpcoder.commons.common.monitor.annoation.EnableMonitor;

/**
 * Created by laidu
 * on 2018-07-10 15:48.
 *
 * @author laidu
 */
@Slf4j
@ConditionalOnClass({EnableMonitor.class})
@ConfigurationProperties(prefix="commons.common.monitor.logging")
public class MonitorProperties {

    /**
     * 日志文件路径
     */
    private String logFile;

    /**
     * 日志级别
     */
    private String Loglevel;




}