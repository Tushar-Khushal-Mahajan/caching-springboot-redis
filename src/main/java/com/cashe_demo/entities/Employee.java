package com.cashe_demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "employee")

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L; // Optional but recommended

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String name;
	private String email;
	private String phone;

}
