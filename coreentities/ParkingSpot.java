package com.parkinglot.coreentities;

import com.parkinglot.coreentities.vehicle.Vehicle;
import com.parkinglot.coreenums.SpotType;

public class ParkingSpot {

	private String spotId;
	private SpotType type;
	private boolean isFree;
	private Vehicle vehicle;

	public String getSpotId() {
		return spotId;
	}

	public void setSpotId(String spotId) {
		this.spotId = spotId;
	}

	public SpotType getType() {
		return type;
	}

	public void setType(SpotType type) {
		this.type = type;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ParkingSpot(String spotId, SpotType type, boolean isFree, Vehicle vehicle) {
		super();
		this.spotId = spotId;
		this.type = type;
		this.isFree = isFree;
		this.vehicle = vehicle;
	}

	public void assignVehicle(Vehicle vehicle) {

		if (this.isFree == false) {
			throw new RuntimeException("This spot is not free");
		}

		this.isFree = false;
		this.vehicle = vehicle;

	}

	public void removeVehicle() {
		this.isFree = true;
		this.vehicle = null;
	}

}
