package com.wenjian.legaltech.eligibility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 扫描当前文件夹下的所有 Controller
public class LegalTechApplication {
	public static void main(String[] args) {
		SpringApplication.run(LegalTechApplication.class, args);
	}
}