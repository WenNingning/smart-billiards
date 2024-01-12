package ning.nc.framework.security.model;
/**
 * 定义JWT基本常量
 * @author Allen
 */
public class JWTConstant {
    /** 10 days */
    public static final String SECRET = "ThisIsASecret";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    /**时间戳失效时间，单位：秒*/
    public static final int INVALID_TIME = 60;
}
