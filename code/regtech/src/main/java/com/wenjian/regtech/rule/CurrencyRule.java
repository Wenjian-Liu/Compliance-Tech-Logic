package com.wenjian.regtech.rule;

import com.wenjian.regtech.domain.Transaction;
import org.springframework.stereotype.Component;

@Component
public class CurrencyRule implements ComplianceRule {

	@Override
	public boolean check(Transaction tx) {
		return !"BTC".equals(tx.getCurrency());
	}

	@Override
	public String getDescription() {
		return "Restricted currency";
	}
}
