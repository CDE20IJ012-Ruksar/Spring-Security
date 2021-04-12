package com.cognizant.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.EmployeeException;
import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {

	
	@Autowired
	EmployeeService service;
	/*
	 http://localhost:9090/employees/allemp
	 methd:get
	 */
	@GetMapping(value = "/allemp",produces = "application/json")
	public List<Employee> getAllEmployees(){
		log.info("started");
		log.debug("Employess are : {}"+service.getEmployees());
		return service.getEmployees();
	}
	
	//http://localhost:9090/employees/1001
	
	@GetMapping(value = "/{id}",produces = "application/json")
	public Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeException{
		log.info("started");
		Employee emp=service.getEmployeeById(id);
		log.debug("Employee is: {}"+emp);
		return emp;
	}
	/*
	 http://localhost:9090/employees/add
	 Method:post
	 body=>raw=>json
	 {
    "id":1003,
    "name":"Diya",
    "age":22,
    "gender":"female",
    "salary":10000,
    "doj":"2011-02-03"
} 
	 */
	@PostMapping(value = "/add")
	public String addEmployee(@Valid @RequestBody Employee e) throws EmployeeException{
		log.info("started");
		log.debug("Employee added: {}"+e);
		return service.addEmployee(e);
	}
	/*
	 * http://localhost:9090/employees/addrequest?id=2002&name=anu&gender=female&age=22&doj=2012-01-01&salary=50000
	 * method:get
	 */
	@GetMapping(value = "/addrequest")
	public String addEmployeewithrequestparam(@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("gender") String gender,
			@RequestParam("salary") double salary,
			@RequestParam("doj") String doj) throws EmployeeException{
		log.info("started");
		LocalDate d=LocalDate.parse(doj);
		Employee e=new Employee(id, name, gender, age, salary, d);
		log.debug("Employee added: {}"+e);
		return service.addEmployee(e);
	}
	/*
	 http://localhost:9090/employees/update
	 method-put
	 body=>raw=json
	 {
    "id":1001,
    "name":"Smith",
    "age":25,
    "gender":"male",
    "salary":12630,
    "doj":"2011-02-03"
}
	 */
	@PutMapping(value = "/update")
	public String updateEmployee(@Valid @RequestBody Employee e) throws EmployeeException{
		log.info("started");
		log.debug("Employee updated: {}"+e);
		return service.updateEmployee(e);
	}
	
	/*
	 *http://localhost:9090/employees/delete/1004
	 *method:delete
	 */
	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id) throws EmployeeException{
		log.info("started");
		
		log.debug("Employee is deleted: {}"+id);
		return service.deleteEmployeeById(id);
	}
	/*
	 * http://localhost:9090/employees/salary/10008/500000
	 * method:get
	 */
	@GetMapping(value = "/salary/{lower}/{upper}",produces = "application/json")
	public List<Employee> getEmployeeBetweenSalary(
			@PathVariable("lower") double lower,@PathVariable("upper") double upper){
		log.info("started");
		log.debug("Employess are : {}"+service.getEmployeeBasedOnSalary(lower, upper));
		return service.getEmployeeBasedOnSalary(lower, upper);
	}
}
