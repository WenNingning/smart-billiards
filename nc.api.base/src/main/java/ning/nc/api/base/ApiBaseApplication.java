package ning.nc.api.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@ComponentScan("ning.nc")
public class ApiBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiBaseApplication.class,args);
    }
}

