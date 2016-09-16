package com.emp.service;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeService {
	public List<Employee> listAllEmployee();
	public Employee getEmployeeById(String emplId);
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(String empId);
}
