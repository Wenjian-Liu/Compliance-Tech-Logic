package com.wenjian.legaltech.eligibility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BgbValidatorTest {

	private final BgbValidator validator = new BgbValidator();

	@Test
	@DisplayName("基本准入：成年且无犯罪记录者应获得资格")
	void should_pass_when_adult_and_clean_history() {
		assertTrue(validator.isEligibleGuardian(18, false, false));
	}

	@Test
	@DisplayName("例外：已婚未成年人应视同成年获得资格")
	void should_pass_when_married_minor() {
		assertTrue(validator.isEligibleGuardian(17, false, true));
	}

	@Test
	@DisplayName("一票否决：无论年龄婚姻，有犯罪记录者一律拒绝")
	void should_fail_when_has_criminal_record() {
		// 核心变量：criminal_record
		assertFalse(validator.isEligibleGuardian(25, true, true));
	}
}