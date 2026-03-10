package com.wenjian.regtech.service;

import com.wenjian.regtech.domain.Transaction;
import com.wenjian.regtech.exception.ComplianceViolationException;
import com.wenjian.regtech.rule.AmountRule;
import com.wenjian.regtech.rule.ComplianceRule;
import com.wenjian.regtech.rule.CurrencyRule;
import io.micrometer.common.util.internal.logging.Slf4JLoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;

@Service
public class AmfComplianceService {

	private static final Logger logger = LoggerFactory.getLogger(AmfComplianceService.class);

	private final List<ComplianceRule> rules;

	public AmfComplianceService(List<ComplianceRule> rules) {
		this.rules = rules;
	}

	/**
	 * Check if transaction arises money laundering alert.
	 * @param tx transaction object
	 * @throws ComplianceViolationException
	 */
	public void validateTransaction(Transaction tx) throws ComplianceViolationException {
		for (ComplianceRule rule : rules) {  // Geldwäscheprävention
			if (!rule.check(tx)) {
				logger.error("[Audit] Transaction {} failed compliance check: {}", tx.getId(), rule.getDescription());
			throw new ComplianceViolationException(rule.getDescription());
		}
	}
	}
}