package xyz.xpcoder.commons.common.monitor.helper;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 日志打印助手
 * <p>
 * Created by laidu
 * on 2018-07-11 14:50.
 *
 * @author laidu
 */

public class LogHelper {

    private static final Logger log = LoggerFactory.getLogger(LogHelper.class);

    public  static  <T extends Serializable> void printJsonLog(T obj){
        log.info(JSON.toJSONString(obj));
    }
}