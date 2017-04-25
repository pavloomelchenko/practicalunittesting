package com.mycompany.put.utils;

import java.util.Properties;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PreserveSystemPropertiesRule implements TestRule {

	private Properties beforeExecution;

	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				beforeExecution = new Properties();
				for (Object property : System.getProperties()
						.keySet()) {
					beforeExecution.setProperty(property.toString(),
							System.getProperty(property.toString()));
				}
				base.evaluate();
				System.setProperties(beforeExecution);
			}
		};
	}

}
