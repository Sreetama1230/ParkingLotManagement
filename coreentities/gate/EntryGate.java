package com.parkinglot.coreentities.gate;

import java.time.LocalDateTime;
import java.util.UUID;

import com.parkinglot.coreentities.ParkingSpot;
import com.parkinglot.coreentities.Ticket;
import com.parkinglot.coreentities.vehicle.Vehicle;
import com.parkinglot.coreenums.TicketStatus;
import com.parkinglot.coreenums.VehicleType;
import com.parkinglot.manager.ParkingSpotManager;

public class EntryGate extends Gate {

	private ParkingSpotManager spotManager;

	public EntryGate(ParkingSpotManager spotManager) {
		super();
		this.spotManager = spotManager;
	}

	public ParkingSpotManager getSpotManager() {
		return spotManager;
	}

	public void setSpotManager(ParkingSpotManager spotManager) {
		this.spotManager = spotManager;
	}

	public Ticket issueTicket(Vehicle vehicle) {
		return new Ticket(UUID.randomUUID().toString(), LocalDateTime.now(), null, TicketStatus.ACTIVE,
				vehicle.getVehicleType());
	}
}
