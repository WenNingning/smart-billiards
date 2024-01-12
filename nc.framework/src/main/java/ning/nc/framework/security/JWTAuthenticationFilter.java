package ning.nc.framework.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Allen
 * jwt 验权filter
 */
public class JWTAuthenticationFilter extends GenericFilterBean {

    private JwtAuthenticationService jwtAuthenticationService;

    public JWTAuthenticationFilter(JwtAuthenticationService jwtAuthenticationService){
        this.jwtAuthenticationService =jwtAuthenticationService;
    }


    /**
     * 拦截客户端发过来的token，进行鉴权
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        jwtAuthenticationService.auth(req);

        filterChain.doFilter(request, response);
    }



}