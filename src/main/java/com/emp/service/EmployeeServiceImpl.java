package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmployeeDao;
import com.emp.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao; 

	@Override
	public List<Employee> listAllEmployee() {		
		return employeeDao.listAllEmployee();
	}

	@Override
	public Employee getEmployeeById(String empId) {
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(String empId) {
		employeeDao.deleteEmployee(empId);
	}	

}
