package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mycompany.put.other.RegexDigitProcessor;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class RegexDigitValidatorTest {
	
	private RegexDigitProcessor regexDigitProcessor = new RegexDigitProcessor();

	@Before
	public void before() {
	}

	@Test
	@Parameters(method = "inputsAndExpectedOutputs")
	public void testRegexAgainstInputsAndExpectedOutputs(String input, String output) {
		assertEquals(output, regexDigitProcessor.process(input));
	}

	protected Object inputsAndExpectedOutputs() {
		return new Object[] { new Object[] { "abc 12", "" },
				new Object[] { "cdefg 345 12bb23", "345" },
				new Object[] { "cdefg 345 12bbb33 678tt", "345, 678" },};
	}
}
