package xyz.xpcoder.commons.common.monitor.processor;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import xyz.xpcoder.commons.common.monitor.MonitorAppTest;
import xyz.xpcoder.commons.common.monitor.annoation.EnableMonitor;
import xyz.xpcoder.commons.common.monitor.service.UserService;

@Slf4j
@EnableMonitor
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MonitorAppTest.class)
class MethodMonitorProcessorTest {

    @Autowired
    UserService userService;

    @Test
    public void addUser(){

        userService.addUser("xiaomign");
    }
}