package com.mycompany.put.other;

import java.util.HashMap;
import java.util.Map;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.mycompany.put.utils.Utils;

public class TimeTestListener extends TestWatcher {
	protected static Map<String, Long> startTimes = new HashMap<>();
	protected static Map<String, TestEntry> testEntries = new HashMap<>();

	@Override
	protected void starting(Description description) {
		String testName = description.getTestClass().getSimpleName() + "." + description.getMethodName();
		startTimes.put(testName, System.currentTimeMillis());
	}

	protected void saveExecutionTime(String result, Description description) {
		String testName = description.getTestClass().getSimpleName() + "." + description.getMethodName();
		TestEntry test = new TestEntry(testName, System.currentTimeMillis() - startTimes.get(testName), result);
		testEntries.put(testName, test);
	}

	@Override
	protected void succeeded(Description description) {
		saveExecutionTime("ok", description);
	}

	@Override
	protected void failed(Throwable e, Description description) {
		saveExecutionTime("FAIL", description);
	}

}

class TestEntry implements Comparable<TestEntry>{
	String classMethodName;
	long executionTime;
	String result;

	public TestEntry(String classMethodName, long executionTime, String result) {
		super();
		this.classMethodName = classMethodName;
		this.executionTime = executionTime;
		this.result = result;
	}

	public String printResult() {
		return String.format("%-4s %-50s %-8s", result, classMethodName, Utils.formatMillis(executionTime));
	}

	@Override
	public int compareTo(TestEntry o) {
		if (o.executionTime < executionTime)
			return 1;
		if (o.executionTime > executionTime)
			return -1;
		return 0;
	}

}