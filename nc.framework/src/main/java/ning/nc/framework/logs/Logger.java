package ning.nc.framework.logs;

/**
 * 日志接口
 * @author Allen
 */
public interface Logger {

    /**
     * info
     * @param log
     */
    void info(String log);

    /**
     * 调试日志
     * @param log
     */
    void debug(String log);

    /**
     * 记录错误日志
     * @param log
     */
    void error(String log);

    /**
     * 错误日志
     * @param log
     * @param throwable
     */
    void error(String log, Throwable throwable);

}
