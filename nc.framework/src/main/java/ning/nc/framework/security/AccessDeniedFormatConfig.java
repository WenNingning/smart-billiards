package ning.nc.framework.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验权失败的异常格式定义
 * Created by Allen
 */

@Configuration
public class AccessDeniedFormatConfig {



    /**
     * 定义认证失败的格式
     * @return
     */
    @Bean
   public AccessDeniedHandler accessDeniedHandler(){
        return new AccessDeniedHandler(){

            @Override
            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                httpServletResponse.setStatus(403);
                httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
                httpServletResponse.getWriter().print("{\"code\":\"403\",\"message\":\"登录状态已失效\"}");
                httpServletResponse.getWriter().flush();
            }
        };
    }

    /**
     * 定义认证失败的格式
     * @return
     */

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse httpServletResponse, AuthenticationException authException)
                    throws IOException, ServletException {
                httpServletResponse.setStatus(403);
                httpServletResponse.setHeader("Content-Type", "application/json;charset=utf-8");
                httpServletResponse.getWriter().print("{\"code\":\"403\",\"message\":\"登录状态已失效\"}");
                httpServletResponse.getWriter().flush();
            }
        };
    }

}
