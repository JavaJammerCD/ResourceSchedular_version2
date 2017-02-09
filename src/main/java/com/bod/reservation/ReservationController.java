package com.bod.reservation;

import java.util.List;

import org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bod.DTO.ReservationDTO;
import com.bod.employee.Employee;

@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/reservations/{deskId}")
	public List<Reservation> findAllReservations(@PathVariable Long deskId){
		return reservationService.getReservationsByDesk(deskId);
	}
	
	@RequestMapping("/reservations")
	public List<Reservation> getReservations (){
		return reservationService.getReservations();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/reservations")
	public void addReservation(@RequestBody ReservationDTO rDTO) {
		reservationService.addReservation(rDTO);
	}
}
