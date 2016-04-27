package com.mycompany.put.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TimeSuiteListener extends TestWatcher {

	@Override
	protected void finished(Description desc) {
		List<TestEntry> tests = new ArrayList<>(TimeTestListener.testEntries.values());
		Collections.sort(tests, Collections.reverseOrder());
		tests.forEach(v -> {
			
			System.out.println(v.printResult());
		});
	}

}