package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

import com.mycompany.put.test.utils.PreserveSystemPropertiesRule;

public class SystemPropsModifierTest {

	static {
		System.getProperties().setProperty(SystemPropsModifier.KEY, "myValue");
	}

	@Rule
	public PreserveSystemPropertiesRule rule = new PreserveSystemPropertiesRule();

	@Test
	public void shouldModifySystemProperty() {
		new SystemPropsModifier().modify();
		assertEquals("myNewValue", System.getProperties().getProperty(SystemPropsModifier.KEY));
	}
}
