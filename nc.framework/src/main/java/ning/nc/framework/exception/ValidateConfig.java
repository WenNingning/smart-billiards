package ning.nc.framework.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * 初始化相关bean
 * @author Allen
 */
@Configuration
public class ValidateConfig {
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor(){
		return new MethodValidationPostProcessor();
	}
}
