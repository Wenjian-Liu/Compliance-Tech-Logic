package com.wenjian.legaltech.exception;

/**
 * 业务异常：合规校验失败
 * 继承RuntimeException以配合Spring的事务回滚和全局异常处理
 */

public class ComplianceViolationException extends RuntimeException{
	private final String region;

	public ComplianceViolationException(String message, String region) {
		super(message);
		this.region = region;
	}

	public String getRegion() {
		return region;
	}
}
