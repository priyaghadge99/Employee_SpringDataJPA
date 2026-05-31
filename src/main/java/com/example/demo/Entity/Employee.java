package com.example.demo.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "Employee")
@Table(name = "Employee")
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name = "email_id")
	private String emailId;

	@Column(name = "dateofjoining")
	private Date dateOfJoining;
	private int age;
	private double salary;
	
	
	public Employee(Long id, String name, String emailId, Date dateOfJoining, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.dateOfJoining = dateOfJoining;
		this.age = age;
		this.salary = salary;
	}
	



	
	
	
	//private List<Order> orders; 

}
