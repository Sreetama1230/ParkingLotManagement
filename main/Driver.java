package com.parkinglot.main;

import java.util.ArrayList;
import java.util.List;

import com.parkinglot.ParkingLot;
import com.parkinglot.coreentities.Level;
import com.parkinglot.coreentities.ParkingSpot;
import com.parkinglot.coreentities.Ticket;
import com.parkinglot.coreentities.gate.EntryGate;
import com.parkinglot.coreentities.gate.ExitGate;
import com.parkinglot.coreentities.payment.Payment;
import com.parkinglot.coreentities.vehicle.Bike;
import com.parkinglot.coreentities.vehicle.Car;
import com.parkinglot.coreentities.vehicle.Vehicle;
import com.parkinglot.coreenums.PaymentMode;
import com.parkinglot.coreenums.SpotType;
import com.parkinglot.coreenums.VehicleType;
import com.parkinglot.manager.ParkingSpotManager;

public class Driver {

	public static void main(String[] args) {

		Level level1 = new Level(1);
		List<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();

		parkingSpots.add(new ParkingSpot("L1-C1", SpotType.COMPACT, true, null));
		parkingSpots.add(new ParkingSpot("L1-C2", SpotType.COMPACT, true, null));
		parkingSpots.add(new ParkingSpot("L1-L1", SpotType.LARGE, true, null));
		parkingSpots.add(new ParkingSpot("L1-M1", SpotType.MOTORBIKE, true, null));
		level1.setSpots(parkingSpots);

		ParkingLot parkingLot = new ParkingLot("Downtown Garage", List.of(level1));

		ParkingSpotManager spotManager = new ParkingSpotManager(parkingLot);
		
		
		EntryGate entryGate = new EntryGate(spotManager);
		ExitGate exitGate = new ExitGate();

		Vehicle car = new Car("KA-01-1234", VehicleType.CAR);


		ParkingSpot assignedSpot = spotManager.findAvailableSpot(car.getVehicleType());
		System.out.println(assignedSpot.getSpotId());
		assignedSpot.assignVehicle(car);
		Ticket ticket = entryGate.issueTicket(car);
		
		
		Vehicle bike = new Bike("DD-01-1234", VehicleType.BIKE);


		ParkingSpot assignedSpotBike = spotManager.findAvailableSpot(bike.getVehicleType());
		System.out.println(assignedSpotBike.getSpotId());
		assignedSpotBike.assignVehicle(bike);
		Ticket ticketBike = entryGate.issueTicket(bike);
	
		Vehicle car1 = new Car("KA-01-1235", VehicleType.CAR);


		ParkingSpot assignedSpot1 = spotManager.findAvailableSpot(car1.getVehicleType());
		assignedSpot1.assignVehicle(car1);
		System.out.println(assignedSpot1.getSpotId());
		Ticket ticket1 = entryGate.issueTicket(car1);
		
		
//		Vehicle car2 = new Car("KA-01-1235", VehicleType.CAR);
//
//		ParkingSpot assignedSpot2 = spotManager.findAvailableSpot(car2.getVehicleType());
//		assignedSpot2.assignVehicle(car2);
//		System.out.println(assignedSpot2.getSpotId());
//		Ticket ticket2 = entryGate.issueTicket(car2);

		System.out.println("Ticket status: " + ticket1.getTicketStatus());
		System.out.println("Spot " + assignedSpot1.getSpotId() + " is free: " + assignedSpot1.isFree());
	
		
		Payment payment = exitGate.processPayment(ticket, PaymentMode.CARD);
		spotManager.releaseSpot(assignedSpot);

		System.out.println("Payment processed: " + payment.getAmount() + " via " + payment.getPaymentMode());
		System.out.println("Ticket status: " + ticket.getTicketStatus());
		System.out.println("Spot " + assignedSpot.getSpotId() + " is free: " + assignedSpot.isFree());

	}

}
