package xyz.xpcoder.commons.common.monitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import xyz.xpcoder.commons.common.monitor.annoation.EnableMonitor;

/**
 * 测试配置
 * <p>
 * Created by laidu
 * on 2018-07-10 18:51.
 *
 * @author laidu
 */
// TODO: 2018-07-10 18:51  测试配置
@Slf4j
@SpringBootApplication
public class MonitorAppTest {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MonitorAppTest.class)
                .logStartupInfo(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }
}