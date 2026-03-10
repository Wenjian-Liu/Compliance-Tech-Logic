package com.wenjian.regtech.rule;

import com.wenjian.regtech.domain.Transaction;
import org.springframework.stereotype.Component;

@Component
public class AmountRule implements ComplianceRule {
	private double maxAmount;

	private static final double LIMIT = 10000.0;

	@Override
	public boolean check(Transaction tx) {
		return tx.getAmount() <= LIMIT;
	}

	@Override
	public String getDescription() {
		return "Amount exceeds limit";
	}
}
