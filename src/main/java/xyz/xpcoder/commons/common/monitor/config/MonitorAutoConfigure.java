package xyz.xpcoder.commons.common.monitor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.xpcoder.commons.common.monitor.helper.LogHelper;
import xyz.xpcoder.commons.common.monitor.helper.impl.Slf4jLogHelper;
import xyz.xpcoder.commons.common.monitor.processor.DefaultLogPrintLogic;
import xyz.xpcoder.commons.common.monitor.processor.LogPrintLogic;
import xyz.xpcoder.commons.common.monitor.processor.MethodMonitorProcessor;

/**
 * 监控 自动化 配置
 * <p>
 * Created by laidu
 * on 2018-07-10 15:47.
 *
 * @author laidu
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(MonitorProperties.class)
public class MonitorAutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    public LogHelper logHelper(){
        return new Slf4jLogHelper();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass({MonitorProperties.class})
    public LogPrintLogic logPrintLogic(){
        return new DefaultLogPrintLogic();
    }



}