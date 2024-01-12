package ning.nc.framework.logs;

/**
 * 日志工厂，实际上用的还是 slf4j,封装了一层
 * @author Allen
 */

public abstract class LoggerFactory {

    /**
     * 获取logger
     * @param claz 调用类
     * @return
     */
    public  static  Logger getLogger(Class<?> claz) {
        org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(claz);
        return new DefaultLoggerImpl(logger);
    }
}
