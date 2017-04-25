package com.mycompany.put.other;

import java.util.LinkedList;
import java.util.List;

public class Stack {
	List<Object> list = new LinkedList<Object>();

	public Object pop() {
		if (list.isEmpty())
			return null;
		Object result = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return result;
	}

	public void push(Object o) {
		list.add(o);
	}
}
