package com.parkinglot.coreentities;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.parkinglot.coreenums.TicketStatus;
import com.parkinglot.coreenums.VehicleType;

public class Ticket {

	private String ticketId;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private TicketStatus ticketStatus;
	private VehicleType vehicleType;

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Ticket() {
		super();
	}

	public Ticket(String ticketId, LocalDateTime entryTime, LocalDateTime exitTime, TicketStatus ticketStatus,
			VehicleType vehicleType) {
		super();
		this.ticketId = ticketId;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.ticketStatus = ticketStatus;
		this.vehicleType = vehicleType;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double calculateFee() {
		ParkingRate parkingRate = new ParkingRate();
		try {
			Thread.sleep(20000);
			this.setExitTime(LocalDateTime.now());
			return parkingRate.calculateFee(this.vehicleType) * 
					ChronoUnit.MINUTES
					.between(this.entryTime, this.exitTime);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
