package com.cognizant.service;

import java.util.List;

import com.cognizant.exception.EmployeeException;
import com.cognizant.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	Employee getEmployeeById(int id) throws EmployeeException;
	String addEmployee(Employee e) throws EmployeeException;
	String updateEmployee(Employee e) throws EmployeeException;
	String deleteEmployeeById(int id) throws EmployeeException;
	List<Employee> getEmployeeBasedOnSalary(double lower,double upper);
}
