package top.simba1949.nacos.client;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @author anthony
 * @version 2023/9/18 15:45
 */
public class NacosClientReadConfigApplication {
	public static void main(String[] args) {
		try {
			// 需要服务端释放 8848 和 9848 端口
			String serverAddr = "192.168.8.100:8848";
			String dataId = "nacos.cfg.dataId";
			String group = "test";
			Properties properties = new Properties();
			properties.put("serverAddr", serverAddr);

			ConfigService configService = NacosFactory.createConfigService(properties);
			// 读取到 dataId=nacos.cfg.dataId 且 group=test 配置信息
			String content = configService.getConfig(dataId, group, 5000);
			// 打印
			System.out.println(content);
		} catch (NacosException e) {
			e.printStackTrace();
		}
	}
}
