package xyz.xpcoder.commons.common.monitor.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.xpcoder.commons.common.monitor.annoation.MethodMonitor;
import xyz.xpcoder.commons.common.monitor.service.UserService;

/**
 * user service
 * <p>
 * Created by laidu
 * on 2018-07-10 18:47.
 *
 * @author laidu
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    @MethodMonitor
    public String addUser(String name) {
        
        log.info("添加用户 : {}", name);
        return name;
    }
}