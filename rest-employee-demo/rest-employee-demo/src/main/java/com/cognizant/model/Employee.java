package com.cognizant.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

	@Id
	private int id;
	@NotBlank(message="Name can't be blank")
//	@Pattern(regexp = "[A-Z]{1}[A-Za-z\\s] {3,}",message = "Name should start with Capital letter followed by only chars")
	private String name;
	@Pattern(regexp = "male|female",message = "Invalid gender")
	private String gender;
	@Min(value=18,message = "age should be >=18")
	@Max(80)
	private Integer age;
	private Double salary;
	@Past
	private LocalDate doj;
	
}
