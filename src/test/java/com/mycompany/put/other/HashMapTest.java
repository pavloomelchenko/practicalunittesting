package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class HashMapTest {
	private HashMap<String, String> map;

	@Before
	public void before() {
		map = new HashMap<String, String>();
	}

	@Test
	@Parameters(method = "validParams")
	public void whenPutShouldRetrieveByGet(String key, String value) {
		map.put(key, value);
		assertEquals(value, map.get(key));
	}

	@Test
	@Parameters(method = "validParams")
	public void addingASecondObjectWithTheSameKeyResultsInTheOldValueBeingReplaced(
			String key, String value) {
		map.put(key, "1");
		assertEquals("1", map.get(key));
		map.put(key, "2");
		assertEquals("2", map.get(key));
	}

	@Test
	@Parameters(method = "validParams")
	public void theClearMethodRemovesAllItsContent(String key,
			String value) {
		map.put(key, "1");
		map.clear();
		assertEquals(0, map.size());
	}

	@Test
	@Parameters(method = "validParams")
	public void theNullValueCanBeUsedAsAKey(String key, String value) {
		map.put(null, value);
		assertEquals(value, map.get(null));
	}

	private Object validParams() {
		return new Object[] { new Object[] { "key1", "value1" },
				new Object[] { "key2", "value2" } };
	}
}
