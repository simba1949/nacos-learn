package top.simba1949.nacos.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author anthony
 * @version 2023/9/18 14:38
 */
@Slf4j
@SpringBootTest
public class NacosConfigTest {

    @Resource
    private NacosConfig nacosConfig;

    @Test
    public void printConfig(){
        log.info("从 nacos 获取到的数据是：{}", nacosConfig);
    }
}
