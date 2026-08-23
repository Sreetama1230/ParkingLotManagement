package com.parkinglot.coreentities.vehicle;


import com.parkinglot.coreenums.VehicleType;

public abstract class Vehicle {

	private String licensePlate;
	private VehicleType vehicleType;
	
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Vehicle(String licensePlate, VehicleType vehicleType) {
		super();
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
	}
	
	
}
