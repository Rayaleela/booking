package com.capg.campsite.dto;

import java.util.List;

public class CampsiteDto {

	private boolean drinkingWater;
	private boolean firePit;
	private int capacity;
	private boolean campsiteTent;
	private boolean availability;
	private boolean restrooms;
	private List<Long> userIdies;



	public CampsiteDto(boolean drinkingWater, boolean firePit, int capacity, boolean campsiteTent, boolean availability,
			boolean restrooms, List<Long> userIdies) {
		super();
		this.drinkingWater = drinkingWater;
		this.firePit = firePit;
		this.capacity = capacity;
		this.campsiteTent = campsiteTent;
		this.availability = availability;
		this.restrooms = restrooms;
		this.userIdies = userIdies;
	}

	public boolean isDrinkingWater() {
		return drinkingWater;
	}

	public void setDrinkingWater(boolean drinkingWater) {
		this.drinkingWater = drinkingWater;
	}

	public boolean isFirePit() {
		return firePit;
	}

	public void setFirePit(boolean firePit) {
		this.firePit = firePit;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isCampsiteTent() {
		return campsiteTent;
	}

	public void setCampsiteTent(boolean campsiteTent) {
		this.campsiteTent = campsiteTent;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean isRestrooms() {
		return restrooms;
	}

	public void setRestrooms(boolean restrooms) {
		this.restrooms = restrooms;
	}

	public List<Long> getUserIdies() {
		return userIdies;
	}

	public void setUserIdies(List<Long> userIdies) {
		this.userIdies = userIdies;
	}
	
	

}
