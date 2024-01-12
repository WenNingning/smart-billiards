package ning.nc.framework.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ning.nc.framework.security.XssStringJsonSerializer;

import java.util.List;

/**
 * 
 * 加载自定义的 拦截器
 * @author Chopper
 * @version v1.0
 * @since v6.2 2019年3月7日 下午5:29:56
 *
 */
@Configuration
public class WebInterceptorConfigurer implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

		//参数蛇形转驼峰拦截
		argumentResolvers.add(new SnakeToCamelModelAttributeMethodProcessor(true));
		argumentResolvers.add(new SnakeToCamelArgumentResolver());

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WdklRequestInterceptor()).addPathPatterns("/**");
	}

	/**
	 * 自定义 ObjectMapper ，用于xss攻击过滤
 	 * @param builder
	 * @return
	 */
	@Bean
	@Primary
	public ObjectMapper xssObjectMapper(Jackson2ObjectMapperBuilder builder) {
		//解析器
		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
		//注册xss解析器
		SimpleModule xssModule = new SimpleModule("XssStringJsonSerializer");
		xssModule.addSerializer(new XssStringJsonSerializer());
		objectMapper.registerModule(xssModule);
		//返回
		return objectMapper;
	}


}
