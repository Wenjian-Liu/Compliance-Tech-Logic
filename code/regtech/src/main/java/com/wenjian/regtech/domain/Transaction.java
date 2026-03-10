package com.wenjian.regtech.domain;

public class Transaction {
	private final String id;  // For immutability
	private final double amount;
	private final String currency;

	public Transaction(String id, double amount, String currency) {
		this.id = id;
		this.amount = amount;
		this.currency = currency;
	}

	// Standard Getters...
	public String getId() {
		return id;
	}

	public double getAmount() { return amount; }

	public String getCurrency() {
		return currency;
	}
}