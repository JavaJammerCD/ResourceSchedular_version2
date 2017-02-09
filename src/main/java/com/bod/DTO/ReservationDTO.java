package com.bod.DTO;

import java.sql.Date;

public class ReservationDTO {

	private int reservationId;
	private int employeeId;
	private long deskId;
//	private Date date;
	private double start_time;
	private double end_time;
	
	public ReservationDTO(){
		
	}
	
	public ReservationDTO(int reservationId, int employeeId, long deskId, double start_time, double end_time) {
		super();
		this.reservationId = reservationId;
		this.employeeId = employeeId;	
		this.deskId = deskId;
//		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
	}

//	public Date getDate() {
//		return date;
//	}

	public long getDeskId() {
		return deskId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public double getEnd_time() {
		return end_time;
	}

	public int getReservationId() {
		return reservationId;
	}

	public double getStart_time() {
		return start_time;
	}

//	public void setDate(Date date) {
//		this.date = date;
//	}

	public void setDeskId(long deskId) {
		this.deskId = deskId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEnd_time(double end_time) {
		this.end_time = end_time;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public void setStart_time(double start_time) {
		this.start_time = start_time;
	}

}
