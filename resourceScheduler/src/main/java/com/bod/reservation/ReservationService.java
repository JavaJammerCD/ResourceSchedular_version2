package com.bod.reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository rr;

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

	public void addReservation(Reservation reservation) {
		if (reservation.getEnd_time() < reservation.getStart_time()) {
			System.out.println("Please ensure the start time is after the end time.");
			return;
		} else if (compareDates(reservation.getDate()) == false) {
			System.out.println("Please ensure selected date is not in the past");
			return;
		} else if (reservation.getDesk().getAvailability() == false) {
			System.out.println("Please select an available desk.");
			return;
		} else {
			try{
			rr.save(reservation);
			reservation.getDesk().setAvailability(false);
			} catch(Exception e){
				
			}
		}
	}

	public boolean compareDates(java.sql.Date a) {
		LocalDate currentDate = LocalDate.now();
		LocalDate bookingDate = a.toLocalDate();
		return currentDate.isBefore(bookingDate);
	}

}
