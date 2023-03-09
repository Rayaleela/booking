package com.capg.campsite.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class BookingDto {

	private LocalDate arrivalDate;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate departureDate;
	private boolean availability;
	private long campsiteId;

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public long getCampsiteId() {
		return campsiteId;
	}

	public void setCampsiteId(long campsiteId) {
		this.campsiteId = campsiteId;
	}

	public BookingDto(LocalDate arrivalDate, LocalDate departureDate, boolean availability, long campsiteId) {
		super();
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.availability = availability;
		this.campsiteId = campsiteId;
	}

}
