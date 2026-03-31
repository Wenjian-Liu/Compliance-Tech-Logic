package com.wenjian.legaltech.eligibility;

public class BgbValidator {
	/**
	 * 资格初筛工具 (Eligibility Validator)
	 * * @param age 候选人的年龄
	 * @param hasCriminal 候选人是否有刑事犯罪记录
	 * @param isMarried 候选人是否已婚
	 * @return true 代表初步具备资格；false 代表法律上存在排除事由
	 */

	public boolean isEligibleGuardian(int age, boolean hasCriminal, boolean isMarried) {
		return hasLegalCapacity(age, isMarried) && isMorallyReliable(hasCriminal);
	}

	private boolean hasLegalCapacity(int age, boolean isMarried) {
		return age >= 18 || isMarried;
	}

	private boolean isMorallyReliable(boolean hasCriminal) {
		return !hasCriminal;
	}
}
