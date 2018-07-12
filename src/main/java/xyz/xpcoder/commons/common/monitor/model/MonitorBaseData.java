package xyz.xpcoder.commons.common.monitor.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by laidu
 * on 2018-07-10 15:56.
 *
 * @author laidu
 */
@Data
public class MonitorBaseData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求 uuid
     */
    private String uuid;

    /**
     * 方法执行时间
     */
    private long elapsedTime;

    /**
     * 方法调用时间
     */
    private long callTime;

    /**
     * 方法签名
     */
    private String methodSignature;

    /**
     * 方法 key
     */
    private String methodKey;

    /**
     * 方法参数
     */
    private String args;

    /**
     * 执行结果
     */
    private String result;

    /**
     * 是否成功
     * 1 成功、0 失败
     */
    private int success = 0;

    /**
     * 异常类型
     */
    private String exceptionClass;

    /**
     * exceptionStackTrace
     */
    private String exceptionStackTrace;


    public void setSuccess(boolean success) {
        this.success = success ? 1 : 0;
    }



}