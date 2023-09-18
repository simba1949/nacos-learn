package top.simba1949.nacos.spring.boot.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

/**
 * <div>
 *     preKey.keyStr=strVal
 *     preKey.keyBl=false
 *     preKey.keyInt=10
 *     preKey.keyBigDecimal=1.100
 *     preKey.keyList=[1,2,3,4,5]
 * </div>
 *
 * @author anthony
 * @version 2023/9/18 14:32
 */
@Data
@Configuration
public class NacosConfig {

    @NacosValue(value = "${preKey.keyStr}")
    private String keyStr;

    @NacosValue(value = "${preKey.keyBl}")
    private boolean keyBl;

    @NacosValue(value = "${preKey.keyInt}")
    private int keyInt;

    @NacosValue(value = "${preKey.keyBigDecimal}")
    private BigDecimal keyBigDecimal;

    @NacosValue(value = "${preKey.keyList}")
    private List<String> keyList;
}