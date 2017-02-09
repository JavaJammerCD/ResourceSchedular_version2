package com.bod.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bod.desk.Desk;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void addEmployee(Employee e) {
		employeeRepository.save(e);
	}
	
	public List <Employee> getAllEmployees(){
		List <Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}
	
	public Employee getEmployee(Integer id) {
		return employeeRepository.findOne(id);
	}
}
