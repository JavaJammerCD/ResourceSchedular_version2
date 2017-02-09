package com.bod.desk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeskService {

	@Autowired
	private DeskRepository deskRepository;

	public List<Desk> findAllDesks() {
		List<Desk> desks = new ArrayList<>();
		deskRepository.findAll().forEach(desks::add);
		return desks;
	}

	public Desk getDesk(Long id) {
		return deskRepository.findOne(id);
	}

	public void addDesk(Desk desk) {
		deskRepository.save(desk);
	}

	public void updateDesk(Long id, Desk desk) {
		deskRepository.save(desk);
	}

	public void removeDesk(Long id) {
		deskRepository.delete(id);
	}
}
