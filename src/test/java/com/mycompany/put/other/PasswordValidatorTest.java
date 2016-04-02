package com.mycompany.put.other;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.mycompany.put.other.PasswordValidator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {

	private static final String validPassword = "pwdpwd12_";
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	private Object params() {
        return new Object[]{new Object[]{"Doesnt match required length", "pwd"},
        		new Object[]{"Doesnt have enough digits", "pwdpwd"},
        		new Object[]{"Doesnt contain underscore", "pwdpwd12"}};
    }
	
	@Test
	@Parameters(method = "params")
	public void ifDoesntMetRequiredConditionAppropriateMessageShouldBeThrown(String message, String password){
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage(message);
		PasswordValidator.validate(password);
	}
	
	@Test
	public void ifHasEnoughDigitsShouldPass(){
		PasswordValidator.validate(validPassword);
	}
	
	@Test
	public void ifContainsUnderscoreShouldPass(){
		PasswordValidator.validate(validPassword);
	}
}
