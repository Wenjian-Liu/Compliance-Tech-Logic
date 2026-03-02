package com.wenjian.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MaskingUtilsTest {

	@ParameterizedTest
	@DisplayName("Verification of different length of emails")
	@CsvSource({
			"wenjian@example.com, w******@example.com",
			"a@test.com, a******@test.com",
			"compliance@de.com, c******@de.com"
	})
	void testMaskEmail(String input, String expected) {
		assertEquals(expected, MaskingUtils.maskEmail(input));
	}

	@Test
	@DisplayName("Verification of different length of emails")
	void testInvalidEmail() {
		assertAll("Masking Email invalid situations",
				() -> assertEquals(null, MaskingUtils.maskEmail(null)),
				() -> assertEquals("invalid-email", MaskingUtils.maskEmail("invalid-email"))
		);
	}
}