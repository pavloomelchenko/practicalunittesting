package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class RegexDigitValidatorTest {

	private RegexDigitProcessor regexDigitProcessor = new RegexDigitProcessor();

	@Test
	@Parameters(method = "inputsAndExpectedOutputs")
	public void testRegexAgainstInputsAndExpectedOutputs(String input, String output) {
		assertEquals(output, regexDigitProcessor.listNumbersOfThreeOrMoreDigits(input));
	}

	@SuppressWarnings("unused")
	private Object inputsAndExpectedOutputs() {
		return new Object[] { new Object[] { "sample 12", "" },
				new Object[] { "sample text 345 12bb23", "345" },
				new Object[] { "sample text 345 12bbb33 678bb", "345, 678" }, };
	}
}
