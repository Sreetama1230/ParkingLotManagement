package com.parkinglot.coreentities;

import com.parkinglot.coreenums.VehicleType;
import com.parkinglot.manager.ParkingSpotManager;

public class ParkingRate {

	public double calculateFee(VehicleType vehicleType) {

		if (VehicleType.BIKE.toString().equals(vehicleType.toString())) {
			return .5;
		}
		if (VehicleType.CAR.toString().equals(vehicleType.toString())) {
			return .15;
		}
		if (VehicleType.TRUCK.toString().equals(vehicleType.toString())) {
			return .25;
		}
		return 1;
	}
}
