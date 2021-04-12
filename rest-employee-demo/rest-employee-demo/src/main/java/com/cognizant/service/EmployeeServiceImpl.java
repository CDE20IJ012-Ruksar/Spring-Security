package com.cognizant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.EmployeeRepository;
import com.cognizant.exception.EmployeeException;
import com.cognizant.model.Employee;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<Employee> getEmployees() {
	log.info("started");
	log.debug("Employees are : {}"+repository.findAll());
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		log.info("started");
		log.debug("Employee is : {}"+repository.findById(id).get());
		return repository.findById(id)
				.orElseThrow(()->new EmployeeException("Employee with the id "+id+" doen't exists"));
	}

	@Override
	public String addEmployee(Employee e) throws EmployeeException {
		log.info("started");
		Optional<Employee> opemp=repository.findById(e.getId());
		if(opemp.isPresent()) {
			log.debug("Already present:{}"+e);
			throw new EmployeeException("Employee with id "+e.getId() +" alread exists");
		}else {
			repository.save(e);
			log.debug("successfully saved :{}"+e);
		}
		return e+"\n added successfully...";
	}

	@Override
	public String updateEmployee(Employee e) throws EmployeeException {
		log.info("started");
		Optional<Employee> opemp=repository.findById(e.getId());
		if(!opemp.isPresent()) {
			
			throw new EmployeeException("Employee with id "+e.getId() +" doesn't exists");
		}else {
			log.debug("Already present:{}"+e);
			Employee emp=opemp.get();
			emp.setId(e.getId());
			emp.setName(e.getName());
			emp.setAge(e.getAge());
			emp.setDoj(e.getDoj());
			emp.setGender(e.getGender());
			repository.save(e);
			log.debug("updated successfully  :{}"+e);
		}
		return e+"\n updated successfully...";
	}

	@Override
	public String deleteEmployeeById(int id) throws EmployeeException {
		log.info("started");
		Optional<Employee> opemp=repository.findById(id);
		if(!opemp.isPresent()) {
			log.debug("Not present:{}"+id);
			throw new EmployeeException("Employee with id "+id +" not exists");
		}else {
			repository.deleteById(id);
			log.debug("deleted successfully :{}"+id);
		}
		return id+"\n deleted successfully...";
	}

	@Override
	public List<Employee> getEmployeeBasedOnSalary(double lower, double upper) {
		log.info("started");
		log.debug("Employees are : {}"+repository.findEmployeesBySalaryBetween(lower, upper));
			return repository.findEmployeesBySalaryBetween(lower, upper);
	}

}
