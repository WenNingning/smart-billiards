package ning.nc.api.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 描述
 *
 * @author wnn
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class ConfigSwagger2 {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("base对接Api文档")
                .description("base对接API接口")
                .version("1.0.0")
                .build();
    }
}
