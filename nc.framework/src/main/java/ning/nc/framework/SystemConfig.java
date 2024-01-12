package ning.nc.framework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 */
@Configuration
@ConfigurationProperties(prefix = "ning")
public class SystemConfig {
    @Value("${ning.timeout.accessTokenTimeout:#{null}}")
    private Integer accessTokenTimeout;
    @Value("${ning.timeout.refreshTokenTimeout:#{null}}")
    private Integer refreshTokenTimeout;
    @Value("${ning.timeout.captchaTimout:#{null}}")
    private Integer captchaTimout;
    @Value("${ning.timeout.smscodeTimout:#{null}}")
    private Integer smscodeTimout;

    @Value("${ning.ssl:#{false}}")
    private boolean ssl;

    @Value("${ning.debugger:#{false}}")
    private boolean debugger;

    public SystemConfig(){}

    /**
     * 获取协议
     *
     * @return 协议
     */
    public final String getScheme() {
        if (this.getSsl()) {
            return "https://";
        }
        return "http://";
    }

    public Integer getAccessTokenTimeout() {
        return accessTokenTimeout;
    }

    public void setAccessTokenTimeout(Integer accessTokenTimeout) {
        this.accessTokenTimeout = accessTokenTimeout;
    }

    public Integer getRefreshTokenTimeout() {
        return refreshTokenTimeout;
    }

    public void setRefreshTokenTimeout(Integer refreshTokenTimeout) {
        this.refreshTokenTimeout = refreshTokenTimeout;
    }

    public Integer getCaptchaTimout() {
        return captchaTimout;
    }

    public void setCaptchaTimout(Integer captchaTimout) {
        this.captchaTimout = captchaTimout;
    }

    public Integer getSmscodeTimout() {
        return smscodeTimout;
    }

    public void setSmscodeTimout(Integer smscodeTimout) {
        this.smscodeTimout = smscodeTimout;
    }

    public boolean getSsl() {
        return ssl;
    }

    public void setSsl(boolean ssl) {
        this.ssl = ssl;
    }

    public boolean isDebugger() {
        return debugger;
    }

    public void setDebugger(boolean debugger) {
        this.debugger = debugger;
    }
}
