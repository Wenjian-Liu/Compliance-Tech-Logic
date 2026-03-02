package com.wenjian.util;

public class MaskingUtils {
	public static String maskEmail(String email) {
		if (email == null || !email.contains("@")) {
			return email;
		}

		int atIndex = email.indexOf("@");
		String prefix = email.substring(0, atIndex);
		String domain = email.substring(atIndex);

		if (prefix.length() > 0) {
			return prefix.charAt(0) + "******" + domain;
		}
		return email;
	}
}
