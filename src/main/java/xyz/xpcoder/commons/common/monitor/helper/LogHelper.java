package xyz.xpcoder.commons.common.monitor.helper;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 日志打印助手
 * <p>
 * Created by laidu
 * on 2018-07-11 14:50.
 *
 * @author laidu
 */
@Slf4j(topic = "monitor")
public class LogHelper {

    public  static  <T extends Serializable> void printJsonLog(T obj){
        log.info(JSON.toJSONString(obj));
    }
}