package com.parkinglot.coreentities.gate;



import com.parkinglot.coreentities.Ticket;
import com.parkinglot.coreentities.payment.Payment;
import com.parkinglot.coreenums.PaymentMode;
import com.parkinglot.coreenums.TicketStatus;

public class ExitGate extends Gate {

	public Payment processPayment(Ticket ticket , PaymentMode paymentMode) {
	
		ticket.setTicketStatus(TicketStatus.PAID);
		double amount = ticket.calculateFee();
		return new Payment(amount, paymentMode);
	}
}
