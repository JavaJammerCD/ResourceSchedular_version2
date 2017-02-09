package com.bod.reservation;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>{

	public List<Reservation> findByDeskId(Long deskId);
}
