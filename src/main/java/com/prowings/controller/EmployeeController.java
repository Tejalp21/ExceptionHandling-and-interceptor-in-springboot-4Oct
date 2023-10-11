package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Employee;
import com.prowings.exception.InValidInputException;
import com.prowings.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable int id) {

		return employeeService.deleteEmployeeById(id);
	}

	@GetMapping("/employees/fetchByName/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {

		if ((name.length() > 2) && (isNameNotContainsDigits(name)))
			return employeeService.getEmployeeByName(name);
		else
			throw new InValidInputException("Invalid Employee Name");
	}

	private boolean isNameNotContainsDigits(String name) {

		for (Character c : name.toCharArray()) {
			if (Character.isDigit(c))
				throw new InValidInputException("Name should not contain any digit!!");
		}
		return true;
	}
}
