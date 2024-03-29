package ning.nc.framework.trigger.rabbitmq.model;

import java.io.Serializable;

/**
 * 延时任务消息
 *
 * @author Allen
 */
public class TimeTriggerMsg implements Serializable {


    private static final long serialVersionUID = 8897917127201859535L;
    /**
     * 执行器beanid
     */
    private String triggerExecuter;

    /**
     * 执行器 执行时间
     */
    private Long triggerTime;


    /**
     * 执行器参数
     */
    private Object param;

    /**
     * 唯一KEY
     */
    private String uniqueKey;


    public TimeTriggerMsg() {
    }

    public TimeTriggerMsg(String triggerExecuter, Object param, Long triggerTime, String uniqueKey) {
        this.triggerExecuter = triggerExecuter;
        this.triggerTime = triggerTime;
        this.param = param;
        this.uniqueKey = uniqueKey;
    }

    public Long getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Long triggerTime) {
        this.triggerTime = triggerTime;
    }

    public String getTriggerExecuter() {
        return triggerExecuter;
    }

    public void setTriggerExecuter(String triggerExecuter) {
        this.triggerExecuter = triggerExecuter;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
