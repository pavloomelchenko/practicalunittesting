package com.mycompany.put.other;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class StackTest {
	private Stack sut = new Stack();

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
