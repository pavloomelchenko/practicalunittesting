package com.mycompany.put.other;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransactionTest {
	private long id = 0l;
	private boolean retryAllowed = false;
	private String message = "Sample message";
	private String billingId = "0";

	private TransactionBuilder sampleTransaction() {
		return new TransactionBuilder().withBillingId(billingId).withId(id)
				.withRetryAllowed(retryAllowed).withMessage(message);
	}

	@Test
	public void creatingProcessingTransactionUsingRegularApproach() {
		Transaction sut = new Transaction(id, State.PROCESSING, retryAllowed, message, billingId);
		assertEquals(State.PROCESSING, sut.getState());
	}

	@Test
	public void creatingProcessingTransactionUsingBuilderPattern() {
		Transaction sut = sampleTransaction().withState(State.PROCESSING).build();
		assertEquals(State.PROCESSING, sut.getState());
	}

}
