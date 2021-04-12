package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private int id;
	private String username;
	private String password;
	private String roles;
	private boolean active;
}


/*
  create table user(id int primary key auto_increment,
    username varchar(25),
   	password varchar(25),
    roles varchar(20),
    active boolean);
    
    insert into user(username,password,roles,active) values("priya","pass","ROLE_ADMIN",true);
    
    insert into user(username,password,roles,active) values("diya","pass","ROLE_USER",true);
 */
