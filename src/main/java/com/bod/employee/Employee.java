package com.bod.employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.bod.reservation.Reservation;

@Entity
public class Employee {

	@Id
	private int id;
	private String first_name;
	private String surname;

	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	private List<Reservation> reservations = new ArrayList<>();

	public Employee() {

	}

	public Employee(int id, String first_name, String surname) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.surname = surname;
	}

	public String getFirst_name() {
		return first_name;
	}

	public int getId() {
		return id;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public String getSurname() {
		return surname;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
