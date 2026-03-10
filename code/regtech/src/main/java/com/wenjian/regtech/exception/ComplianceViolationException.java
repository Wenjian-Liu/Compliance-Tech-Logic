package com.wenjian.regtech.exception;

public class ComplianceViolationException extends Exception {  // Exception Type should be clear.
	public ComplianceViolationException(String message) {
		super(message);
	}
}