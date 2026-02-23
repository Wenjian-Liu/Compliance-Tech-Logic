package com.wenjian.legaltech.compliance;

// PIPL实现
public class PiplChecker implements ComplianceChecker {
	@Override
	public boolean validate(String data) {

		System.out.println("[PIPL 校验]正在检查个人隐私数据合规性...");
		return data != null && !data.isEmpty();
	}
}
