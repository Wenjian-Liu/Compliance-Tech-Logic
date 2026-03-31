package com.wenjian.legaltech.eligibility;

import lombok.Data;

@Data
public class ComplianceDTO {
	private int age;
	private boolean eligible;
	private String legalBasis;
	private String message;

	public ComplianceDTO(int age, boolean eligible, String legalBasis, String message) {
		this.age = age;
		this.eligible = eligible;
		this.legalBasis = legalBasis;
		this.message = message;
	}
}