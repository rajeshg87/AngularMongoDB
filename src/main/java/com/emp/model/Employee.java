package com.emp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.emp.util.View;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Document
public class Employee {
	
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("id")
	@Id
	String empId;
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("name")
	String empName;
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("desg")
	String empDesg;
	@JsonView(View.EmployeeJsonView.class)
	@JsonProperty("salary")
	Long salary;
	
	public Employee() {
		super();
	}
	
	public Employee(String empId, String empName, String empDesg, Long salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesg = empDesg;
		this.salary = salary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesg() {
		return empDesg;
	}
	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesg=" + empDesg + ", salary=" + salary
				+ "]";
	}
	
}