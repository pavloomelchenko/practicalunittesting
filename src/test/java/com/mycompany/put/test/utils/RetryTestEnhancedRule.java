package com.mycompany.put.test.utils;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RetryTestEnhancedRule implements TestRule {
	@Override
	public Statement apply(final Statement base, final Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				if (description.getAnnotation(RetryTest.class) != null) {
					for (int i = 0; i < description.getAnnotation(RetryTest.class).retryNb(); i++) {
						try {
							base.evaluate();
						} catch (AssertionError ae) {
						}
					}
					return;
				}
				base.evaluate();
			}
		};
	}

}
