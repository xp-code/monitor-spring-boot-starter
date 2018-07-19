package xyz.xpcoder.commons.common.monitor.helper;

import java.io.Serializable;

/**
 * 日志打印逻辑
 * <p>
 * Created by laidu
 * on 2018-07-16 16:53.
 *
 * @author laidu
 */
public interface LogHelper {

    /**
     * 日志打印逻辑
     * @param obj
     * @param <T>
     */
    <T extends Serializable> void printJsonLog(T obj);


}
