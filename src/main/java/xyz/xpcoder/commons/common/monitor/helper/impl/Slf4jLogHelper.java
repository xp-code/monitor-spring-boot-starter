package xyz.xpcoder.commons.common.monitor.helper.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import xyz.xpcoder.commons.common.monitor.helper.LogHelper;

import java.io.Serializable;

/**
 * 日志打印助手
 * <p>
 * Created by laidu
 * on 2018-07-11 14:50.
 *
 * @author laidu
 */
@Slf4j
public class Slf4jLogHelper implements LogHelper {

    @Override
    public   <T extends Serializable> void printJsonLog(T obj){
        log.info(JSON.toJSONString(obj));
    }
}