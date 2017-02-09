package com.bod.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addDesk(@RequestBody Employee e) {
		employeeService.addEmployee(e);
	}
	
	@RequestMapping(value="/employees")
	public List<Employee> findAllEmployees(){
		return employeeService.getAllEmployees();
	}
	

}
