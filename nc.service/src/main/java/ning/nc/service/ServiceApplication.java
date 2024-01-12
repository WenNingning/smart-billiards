package ning.nc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 描述
 *
 * @author allen
 * 2020-09-04 12:24
 */
@SpringBootApplication
@ComponentScan("ning.nc")
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
