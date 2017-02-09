package com.bod.desk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeskController {

	@Autowired
	private DeskService deskService;

	@RequestMapping("/desks")
	public List<Desk> getAllTopics() {
		return deskService.findAllDesks();
	}

	@RequestMapping("/desks/{id}")
	public Desk getDesk(@PathVariable Long id) {
		return deskService.getDesk(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/desks")
	public void addDesk(@RequestBody Desk desk) {
		deskService.addDesk(desk);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/desks/{id}")
	public void updateDesk(@RequestBody Desk desk, @PathVariable Long id) {
		deskService.updateDesk(id, desk);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/desks/{id}")
	public void removeDesk(@PathVariable Long id) {
		deskService.removeDesk(id);
	}

}
