package com.cognizant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findEmployeesBySalaryBetween(double lower,double higher);
}
