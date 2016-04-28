package com.mycompany.put.other;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {
	Stack sut = new Stack();

	@Test
	public void shouldPopNullWhenEmpty() {
		assertNull(sut.pop());
	}

	@Test
	public void shouldPopWhenPushed() {
		Object o = new Object();
		sut.push(o);
		assertSame(o, sut.pop());
	}

	@Test
	public void shouldRemoveAfterPop() {
		Object o = new Object();
		sut.push(o);
		sut.pop();
		assertNull(sut.pop());
	}
}
