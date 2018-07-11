package xyz.xpcoder.commons.common.monitor.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    MonitorProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public MethodMonitorProcessor methodMonitorProcessor(){
        return new MethodMonitorProcessor();
    }




}