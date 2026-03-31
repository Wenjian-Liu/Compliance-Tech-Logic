package com.wenjian.legaltech.service;

import com.wenjian.legaltech.compliance.ComplianceChecker;
import com.wenjian.legaltech.exception.ComplianceViolationException;
import org.springframework.stereotype.Service;

@Service
public class DataService {
	private final ComplianceChecker checker;

	// 自动注入
	public DataService(ComplianceChecker checker) {
		this.checker = checker;
	}

	public void processData(String input) {
		// 如果校验不通过，直接中断执行流程
		if (!checker.validate(input)) { throw new ComplianceViolationException("Data compliance check failed!", "EU/CN");
		}

		// 只有校验通过才会执行后续逻辑
		System.out.println(">>> 结果：合规通过，数据已入库。");
	}
}
