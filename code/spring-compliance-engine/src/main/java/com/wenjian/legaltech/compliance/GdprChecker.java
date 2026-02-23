package com.wenjian.legaltech.compliance;

public class GdprChecker implements ComplianceChecker {
	@Override
	public boolean validate(String data) {

		System.out.println("[GDPR 校验]正在执行欧盟数据保护条例审查...");
		return data != null && data.contains("@");
	}
}
