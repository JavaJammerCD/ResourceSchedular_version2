package com.bod.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int id;
	private String first_name;
	private String surname;

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

	public String getSurname() {
		return surname;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
