package com.wenjian.legaltech.config;

import com.wenjian.legaltech.compliance.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LegalConfig {

	@Bean
	@ConditionalOnProperty(name = "compliance.type", havingValue = "PIPL")
	public ComplianceChecker piplChecker() {
		return new PiplChecker();
	}

	@Bean
	@ConditionalOnProperty(name = "compliance.type", havingValue = "GDPR")
	public ComplianceChecker gdprChecker() {
		return new GdprChecker();
	}

	@Bean
	@ConditionalOnMissingBean(ComplianceChecker.class)
	public ComplianceChecker defaultChecker() {
		// 如果不配置，则默认使用PIPL或通用校验
		return new PiplChecker();
	}
}
