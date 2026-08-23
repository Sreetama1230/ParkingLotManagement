package com.parkinglot.manager;

import com.parkinglot.ParkingLot;
import com.parkinglot.coreentities.Level;
import com.parkinglot.coreentities.ParkingSpot;
import com.parkinglot.coreenums.SpotType;
import com.parkinglot.coreenums.VehicleType;

public class ParkingSpotManager {

	private ParkingLot parkingLot;

	public ParkingSpotManager(ParkingLot parkingLot) {
		super();
		this.parkingLot = parkingLot;
	}

	public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
		SpotType requiredType = getSpotType(vehicleType);

		for (Level l : parkingLot.getLevels()) {
			for (ParkingSpot parkingSpot : l.getAvailableSpots()) {
				
				if (parkingSpot.getType() == requiredType && parkingSpot.isFree() == true) {
					
					return parkingSpot;
				}
			}
		}
	    throw new RuntimeException("No available spot for vehicle type: " + vehicleType);


	}

	public void releaseSpot(ParkingSpot parkingSpot) {
		parkingSpot.removeVehicle();
	};

	private SpotType getSpotType(VehicleType vehicleType) {
		switch (vehicleType) {
		case BIKE:
			return SpotType.MOTORBIKE;
		case TRUCK:
			return SpotType.LARGE;
		case CAR:
			return SpotType.COMPACT;
		default:
			throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
		}
	}
}
