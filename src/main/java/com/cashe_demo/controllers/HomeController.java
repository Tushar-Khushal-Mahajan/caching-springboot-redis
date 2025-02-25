package com.cashe_demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashe_demo.entities.Employee;
import com.cashe_demo.services.EmployeeService;

@RestController
@RequestMapping(value = "emp")
public class HomeController {

	@Autowired
	private EmployeeService service;

	@GetMapping
	public List<Employee> getAllEmp() {
		return service.getAllEmployees();
	}

	@PostMapping()
	public Employee saveEmployee(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}

	@GetMapping("/{empId}")
	public Employee getEmpById(@PathVariable("empId") int empId) {
		return service.getById(empId);
	}
	
	@GetMapping("/show-cache")
	public String showRedisData() {
		
		service.showAllKeys();
		
		return "data printed on console..";
	}
}
