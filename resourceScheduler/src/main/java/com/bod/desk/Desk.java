package com.bod.desk;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Desk {

	@Id
	private long id;

	private String resourceName;

	private double x;

	private double y;

	private boolean available = true;

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

	public long getId() {
		return id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public boolean getAvailability() {
		return available;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setAvailability(boolean available) {
		this.available = available;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
