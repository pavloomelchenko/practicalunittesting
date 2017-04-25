package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mycompany.put.utils.Utils;

public class UtilsTest {

	@Test
	public void shouldCamelCaseSentence() {
		String s = "one user is returned if only one has been added";
		assertEquals("oneUserIsReturnedIfOnlyOneHasBeenAdded", Utils.camelCaseSentence(s));
	}

}
