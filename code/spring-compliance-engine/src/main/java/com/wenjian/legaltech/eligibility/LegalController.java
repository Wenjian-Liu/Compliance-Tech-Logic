package com.wenjian.legaltech.eligibility;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 可被浏览器访问的控制器
public class LegalController {

	private final BgbValidator validator = new BgbValidator();

	@GetMapping("/api/check-guardian")
	public ComplianceDTO checkGuardian(
			@RequestParam int age,
			@RequestParam boolean hasCriminal,
			@RequestParam boolean isMarried) {

		// 1. 调用核心法律
		boolean isEligible = validator.isEligibleGuardian(age, hasCriminal, isMarried);

		// 2. 核心改进：根据布尔值结果，动态生成文案
		String msg;
		if (!isEligible) {
			if (age < 18 && !isMarried) {
				msg = "由于未成年且未婚，不符合适格性要求";
			} else if (hasCriminal) {
				msg = "由于存在刑事记录，不符合适格性要求";
			} else {
				msg = "综合评估不通过";
			}
		} else {
			msg = "初步审查通过";
		}

		// 3. 将动态的 msg 加入 DTO
		return new ComplianceDTO(age, isEligible, "Law related", msg);
	}
}