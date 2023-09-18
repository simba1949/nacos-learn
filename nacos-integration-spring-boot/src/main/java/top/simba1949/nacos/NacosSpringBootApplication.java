package top.simba1949.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anthony
 * @version 2023/9/18 14:20
 */
@NacosPropertySource(dataId = "TEST_DATA_ID", groupId = "DEFAULT_GROUP", autoRefreshed = true)
@SpringBootApplication
public class NacosSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosSpringBootApplication.class, args);
    }
}
