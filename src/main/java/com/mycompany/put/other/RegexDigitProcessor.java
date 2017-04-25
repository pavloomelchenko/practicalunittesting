package com.mycompany.put.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDigitProcessor {

	private static final String REGEXP = "-?\\d+";

	public String listNumbersOfThreeOrMoreDigits(String input) {
		Pattern p = Pattern.compile(REGEXP);
		Matcher m = p.matcher(input);
		String result = "";
		while (m.find()) {
			if (m.group().length() >= 3) {
				result += m.group();
				result += ", ";
			}
		}
		StringBuilder b = new StringBuilder(result);
		if (result.lastIndexOf(",") != -1) {
			b.replace(result.lastIndexOf(","),
					result.lastIndexOf(",") + 1, "");
		}

		return b.toString().trim();
	}

}
