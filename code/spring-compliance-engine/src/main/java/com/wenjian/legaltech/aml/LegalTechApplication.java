package com.wenjian.legaltech;

import com.wenjian.legaltech.exception.ComplianceViolationException;
import com.wenjian.legaltech.service.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LegalTechApplication {

	public static void main(String[] args) {
		//1. 启动并获取容器上下文
		ConfigurableApplicationContext context = SpringApplication.run(LegalTechApplication.class, args);

		//2. 从容器中获取DataService实例
		DataService dataService = context.getBean(DataService.class);

		//3. 运行业务逻辑测试
		try {

			System.out.println("\n=== 法律合规审计测试开始 ===");

			System.out.println("--- 场景A：开始执行正常业务 ---");
			dataService.processData("text@example.com");  //预期通过

			System.out.println("\n--- 场景B：开始执行违规测试 ---");
			dataService.processData("invalid_data");  //预期抛出异常

			} catch (ComplianceViolationException e) {
				System.err.println("[合规警报] 拦截到违规操作：" + e.getMessage() + " | 地区：" + e.getRegion());
		}
	}
}
