package com.prowings.service;

import java.util.List;

import com.prowings.entity.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public String deleteEmployeeById(int id);

	public Employee getEmployeeByName(String name);

}
