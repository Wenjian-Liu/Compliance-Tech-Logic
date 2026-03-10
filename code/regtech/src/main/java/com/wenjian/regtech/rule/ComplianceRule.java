package com.wenjian.regtech.rule;

import com.wenjian.regtech.domain.Transaction;

public interface ComplianceRule {
	boolean check(Transaction tx);

	String getDescription();
}
