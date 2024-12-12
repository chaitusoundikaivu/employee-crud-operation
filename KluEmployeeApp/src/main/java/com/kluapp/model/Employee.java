package com.kluapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long eid;
	private String ename;
	private int esal;
	private String eimage;
	private String edesig;
}
