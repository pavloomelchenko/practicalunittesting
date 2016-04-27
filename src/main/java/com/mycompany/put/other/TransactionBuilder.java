package com.mycompany.put.other;

public class TransactionBuilder {
	private long id;
	private State state;
	private boolean retryAllowed;
	private String message;
	private String billingId;

	public TransactionBuilder withId(long id) {
		return this;
	}

	public TransactionBuilder withState(State state) {
		this.state = state;
		return this;
	}

	public TransactionBuilder withRetryAllowed(boolean retryAllowed) {
		return this;
	}

	public TransactionBuilder withMessage(String message) {
		return this;
	}

	public TransactionBuilder withBillingId(String billingId) {
		return this;
	}
	
	public Transaction build(){
		return new Transaction(id, state, retryAllowed, message, billingId);
	}
}
