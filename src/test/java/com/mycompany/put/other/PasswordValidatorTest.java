package com.mycompany.put.other;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

	private static final String validPassword = "pwdpwd12_";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private PasswordValidator passwordValidator = new PasswordValidator();

	private Object params() {
		return new Object[] {
				new Object[] { "Password doesn't match required length",
						"pwd" },
				new Object[] { "Password doesn't have enough digits",
						"pwdpwd" },
				new Object[] { "Password doesn't contain underscore",
						"pwdpwd12" } };
	}

	@Test
	@Parameters(method = "params")
	public void ifDoesntMetRequiredConditionAppropriateMessageShouldBeThrown(
			String message, String password) {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage(message);
		passwordValidator.validate(password);
	}

	@Test
	public void ifHasEnoughDigitsShouldPass() {
		passwordValidator.validate(validPassword);
	}

	@Test
	public void ifContainsUnderscoreShouldPass() {
		passwordValidator.validate(validPassword);
	}
}
