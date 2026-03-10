package com.wenjian.regtech.rule;

import static org.junit.jupiter.api.Assertions.*;

import com.wenjian.regtech.domain.Transaction;
import org.junit.jupiter.api.Test;

class AmountRuleTest {

	@Test
	void check() {
		//	1.创建 AmountRule
		AmountRule rule = new AmountRule();

		//	2.创建 Transaction
		Transaction tx = new Transaction("123", 50000, "RMB");

		//	3.调用 check
		boolean result = rule.check(tx);

		//	4.使用断言判断返回值
		assertFalse(result);
		System.out.println(rule.getDescription());
	}
}