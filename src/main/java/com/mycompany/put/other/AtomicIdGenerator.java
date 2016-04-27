package com.mycompany.put.other;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicIdGenerator implements IdGenerator {
	private static AtomicLong nextId = new AtomicLong();

	public Long nextId() {
		return nextId.incrementAndGet();
	}
}