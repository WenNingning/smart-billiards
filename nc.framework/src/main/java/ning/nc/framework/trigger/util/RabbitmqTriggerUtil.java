package ning.nc.framework.trigger.util;

/**
 * 延时任务mq实现内容，提供加密算法以及任务前缀参数
 *
 * @author Allen
 */
public class RabbitmqTriggerUtil {

    /**
     * 前缀
     */
    private static final String PREFIX = "rabbitmq_trigger_";

    /**
     * 生成延时任务标识key
     *
     * @param executerName 执行器beanid
     * @param triggerTime  执行时间
     * @param uniqueKey    自定义表示
     * @return
     */
    public static String generate(String executerName, Long triggerTime, String uniqueKey) {
        return PREFIX + (executerName + triggerTime + uniqueKey).hashCode();
    }


}
