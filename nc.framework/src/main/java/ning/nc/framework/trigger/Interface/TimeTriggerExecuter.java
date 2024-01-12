package ning.nc.framework.trigger.Interface;

/**
 * 延时任务执行器接口
 * @author Allen
 *
 */
public interface TimeTriggerExecuter {


    /**
     * 执行任务
     * @param object 任务参数
     */
    void execute(Object object);

}
