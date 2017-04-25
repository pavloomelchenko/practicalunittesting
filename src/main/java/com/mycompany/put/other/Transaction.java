package com.mycompany.put.other;

public class Transaction {
	private long id;
	private State state;
	private boolean retryAllowed;
	private String message;
	private String billingId;

	public Transaction(long id, State state, boolean retryAllowed,
			String message, String billingId) {
		super();
		this.id = id;
		this.state = state;
		this.retryAllowed = retryAllowed;
		this.message = message;
		this.billingId = billingId;
	}

	// getters and setters omitted
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isRetryAllowed() {
		return retryAllowed;
	}

	public void setRetryAllowed(boolean retryAllowed) {
		this.retryAllowed = retryAllowed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getBillingId() {
		return billingId;
	}

	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (id != other.id)
			return false;
		return true;
	}

}