package com.parkinglot;

import java.util.List;

import com.parkinglot.coreentities.Level;

public class ParkingLot {

	private String name;
	
	List<Level> levels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}

	public ParkingLot(String name, List<Level> levels) {
		super();
		this.name = name;
		this.levels = levels;
	}
	
	public Level getLevel(int id) {
		return levels.get(id);
	}
	
}
