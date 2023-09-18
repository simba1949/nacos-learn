package top.simba1949.nacos.client;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author anthony
 * @version 2023/9/18 15:37
 */
public class NacosClientListenerConfigApplication {
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

			// 添加监听
			configService.addListener(dataId, group, new Listener() {
				@Override
				public void receiveConfigInfo(String configInfo) {
					System.out.println("接收到配置信息变动，新配置信息是：" + configInfo);
				}

				@Override
				public Executor getExecutor() {
					return null;
				}
			});
		} catch (NacosException e) {
			e.printStackTrace();
		}

		try {
			// 阻止程序运行结束
			new CountDownLatch(1).await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
