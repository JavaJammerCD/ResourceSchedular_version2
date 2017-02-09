package com.bod.reservation;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import com.bod.desk.Desk;
import com.bod.employee.Employee;

@Entity
public class Reservation {

	@Id
	private int reservation_id;
//	private Date date;
	private double start_time;
	private double end_time;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DESK_ID")
	private Desk desk;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private Employee employee;

	public Reservation() {
	}

	public Reservation(int id, double start_time, Desk desk, double end_time, Employee employee) {
		super();
		this.reservation_id = id;
//		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.desk = desk;
		this.employee = employee;
	}

//	public Date getDate() {
//		return date;
//	}

	public Desk getDesk() {
		return desk;
	}

	public Employee getEmployee() {
		return employee;
	}

	public double getEnd_time() {
		return end_time;
	}

	public int getId() {
		return reservation_id;
	}

	public int getReservation_id() {
		return reservation_id;
	}

	public double getStart_time() {
		return start_time;
	}

//	public void setDate(Date date) {
//		this.date = date;
//	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEnd_time(double end_time) {
		this.end_time = end_time;
	}

	public void setId(int id) {
		this.reservation_id = id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public void setStart_time(double start_time) {
		this.start_time = start_time;
	}

}
