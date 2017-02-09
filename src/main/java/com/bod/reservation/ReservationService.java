package com.bod.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bod.DTO.ReservationDTO;
import com.bod.desk.Desk;
import com.bod.desk.DeskService;
import com.bod.employee.Employee;
import com.bod.employee.EmployeeService;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository rr;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DeskService deskService;

	public List<Reservation> getReservationsByDesk(Long deskId) {
		List<Reservation> reservations = new ArrayList<>();
		rr.findByDeskId(deskId).forEach(reservations::add);
		return reservations;
	}

	public List<Reservation> getReservations() {
		List<Reservation> reservations = new ArrayList<>();
		rr.findAll().forEach(reservations::add);
		return reservations;
	}

	public void addReservation(ReservationDTO rDTO) {
		System.out.println(rDTO.getDeskId());
		Employee employee = employeeService.getEmployee(rDTO.getEmployeeId());
		Desk desk = deskService.getDesk(rDTO.getDeskId());
		Reservation reservation = new Reservation(
				rDTO.getReservationId(), 
				rDTO.getStart_time(), desk, rDTO.getEnd_time(),
			 employee);
		System.out.println(reservation.getEnd_time());
		
		if (reservation.getEnd_time() < reservation.getStart_time()) {
			System.out.println("Please ensure the start time is after the end time.");
			return;
//		} else if (!compareDates(reservation.getDate())) {
//			System.out.println("Please ensure selected date is not in the past");
//			return;
			// } else if (reservation.getDesk().getAvailability() == false) {
			// System.out.println("Please select an available desk.");
			// return;
		} else {
			try {
				System.out.println(reservation.getDesk().getResourceName());
				System.out.println(reservation.getEmployee().getFirst_name());
				reservation.setDesk(desk);
				reservation.setEmployee(employee);
				employee.getReservations().add(reservation);
				desk.getReservations().add(reservation);
				rr.save(reservation);
				// reservation.getDesk().setAvailability(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean compareDates(java.sql.Date a) {
		LocalDate currentDate = LocalDate.now();
		LocalDate bookingDate = a.toLocalDate();
		return currentDate.isBefore(bookingDate);
	}
}
