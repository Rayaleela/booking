package com.capg.campsite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Campsite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int siteId;
	private boolean drinkingWater;
	private boolean firePit;
	private int capacity;
	private boolean campsiteTent;
	private boolean availability;
	private boolean restrooms;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_fk")
	private List<User> user;

	public Campsite() {
		super();
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
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

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Campsite(int siteId, boolean drinkingWater, boolean firePit, int capacity, boolean campsiteTent,
			boolean availability, boolean restrooms, List<User> user) {
		super();
		this.siteId = siteId;
		this.drinkingWater = drinkingWater;
		this.firePit = firePit;
		this.capacity = capacity;
		this.campsiteTent = campsiteTent;
		this.availability = availability;
		this.restrooms = restrooms;
		this.user = user;
	}

}
