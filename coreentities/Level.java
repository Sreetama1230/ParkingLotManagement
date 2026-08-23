package com.parkinglot.coreentities;

import java.util.ArrayList;
import java.util.List;

public class Level {

	private int floorNumber;
	private List<ParkingSpot> spots;

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public List<ParkingSpot> getSpots() {
		return spots;
	}

	public void setSpots(List<ParkingSpot> spots) {
		this.spots = spots;
	}

	public Level(int floorNumber, List<ParkingSpot> spots) {
		super();
		this.floorNumber = floorNumber;
		this.spots = spots;
	}

	public Level(int floorNumber) {
		super();
		this.floorNumber = floorNumber;
	}

	public List<ParkingSpot> getAvailableSpots() {
		List<ParkingSpot> availableSpots = new ArrayList<ParkingSpot>();

		for (ParkingSpot parkingSpot : this.spots) {
			if (parkingSpot.isFree()) {
				availableSpots.add(parkingSpot);
			}
		}
		return availableSpots;
	}
}
