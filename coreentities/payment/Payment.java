package com.parkinglot.coreentities.payment;

import com.parkinglot.coreenums.PaymentMode;

public class Payment {

	private double amount;
	private PaymentMode paymentMode;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Payment(double amount, PaymentMode paymentMode) {
		super();
		this.amount = amount;
		this.paymentMode = paymentMode;
	}

	public void processPayment() {
		if (this.amount < 0) {
			throw new RuntimeException("amount should be greater than 0");
		}
		// CASH,CARD,UPI
		switch (this.paymentMode) {
		case CASH: {
			System.out.println("Payment mode is cash");
			break;
		}

		case CARD: {
			System.out.println("Payment mode is card");
			break;
		}

		case UPI: {
			System.out.println("Payment mode is upi");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.paymentMode);
		}
	}
}
