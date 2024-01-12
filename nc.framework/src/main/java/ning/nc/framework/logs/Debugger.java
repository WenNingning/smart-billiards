package ning.nc.framework.logs;

import ning.nc.framework.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ning.nc.framework.SystemConfig;

/**
 * 调试器
 * @author Allen
 */
@Component
public class Debugger {

    @Autowired
    private SystemConfig systemConfig;

    @Autowired
    private Cache cache;

    private static final String LOG_KEY="debug_log";


    /**
     * 记录多个并换行
     */
    public void log(String... ar) {

        String str = "";
        for (String s : ar) {
            str+="<br>"+s;
        }

        log(str);
    }

    /**
     * 记录日志
     * @param str
     */
    public void log(String str) {
        //只有debugger开启才操作
        if (!systemConfig.isDebugger()) {
            return;
        }

       String logStr =(String) cache.get(LOG_KEY);
        if (logStr == null) {
            logStr = "";
        }

        logStr+="<br/>"+str;

        /**
         * 日志记录默认为10分后失效
         */
        cache.put(LOG_KEY, logStr, 10 * 60);
    }


    /***
     * 获取日志
     * @return
     */
    public String getLog() {
        //只有debugger开启才操作
        if (!systemConfig.isDebugger()) {
            return "";
        }
        String logStr =(String) cache.get(LOG_KEY);
        if (logStr == null) {
            logStr = "";
        }

        return logStr;
    }

    /**
     * 清空日志
     */
    public void clear() {
        //只有debugger开启才操作
        if (!systemConfig.isDebugger()) {
            return;
        }
        cache.remove(LOG_KEY);

    }
}
