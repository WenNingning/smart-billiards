package ning.nc.framework.logs;

/**
 * 默认的logger实现
 * @author Allen
 */

public class DefaultLoggerImpl implements Logger  {

    /**
     * 构造器，必须用slf4j loggger来初始化
     * @param logger
     */
    public DefaultLoggerImpl(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    private  org.slf4j.Logger logger;

    @Override
    public void info(String log) {
        if (logger.isInfoEnabled()) {
            logger.info(log);
        }
    }

    @Override
    public void debug(String log) {
        if (logger.isDebugEnabled()) {
            logger.debug(log);
        }


    }

    @Override
    public void error(String log) {
        logger.error(log);

    }

    @Override
    public void error(String log, Throwable throwable) {
        logger.error(log,throwable);
    }
}
