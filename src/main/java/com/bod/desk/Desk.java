package com.bod.desk;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.bod.reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Desk {

	@Id
	@Column(name="DESK_ID")
	private long id;

	private String resourceName;

	private double x;

	private double y;

	private boolean available = true;
	
	@OneToMany(mappedBy="desk",cascade=CascadeType.ALL)
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Desk() {

	}

	public Desk(long id, String resourceName, double x, double y, boolean available) {
		super();
		this.id = id;
		this.resourceName = resourceName;
		this.x = x;
		this.y = y;
		this.available = available;
	}

	public boolean getAvailability() {
		return available;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public long getId() {
		return id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setAvailability(boolean available) {
		this.available = available;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
