package com.emp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.emp.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "employee";

	public List<Employee> listAllEmployee() {
		List<Employee> employees = mongoTemplate.findAll(Employee.class,COLLECTION_NAME);
		return employees;
	}

	public Employee getEmployeeById(String empId) {
		Employee employee = mongoTemplate.findById(empId, Employee.class);
		return employee;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		if (!mongoTemplate.collectionExists(Employee.class)) {
			mongoTemplate.createCollection(Employee.class);
		}		
		String mongoId = UUID.randomUUID().toString();
		System.out.println("MONGO ID : "+mongoId);
		employee.setEmpId(mongoId);
		mongoTemplate.insert(employee, COLLECTION_NAME);
		return employee;
	}

	@Override
	public void deleteEmployee(String empId) {
		Employee employee = getEmployeeById(empId);		
		mongoTemplate.remove(employee, COLLECTION_NAME);
	}
}
