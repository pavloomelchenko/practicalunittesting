package com.mycompany.put.other;

import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Fridge {
	private Collection<String> food = new HashSet<String>();

	public boolean put(String item) {
		return food.add(item);
	}

	public boolean contains(String item) {
		return food.contains(item);
	}

	public void take(String item) {
		boolean result = food.remove(item);
		if (!result) {
			throw new NoSuchElementException(item + " not found in the fridge");
		}
	}
}