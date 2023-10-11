package com.prowings.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@NotEmpty(message = "Name could not be empty or null.")
    @Size(min = 6, max = 100, message = "Name must contains min 36 or max 100 characters.")
	@Column
	String name;

	@NotEmpty(message = "City could not be empty or null.")
	@Column
	String city;

	@Column
	int salary;

	@NotEmpty(message = "Department could not be empty or null.")
	@Column
	String department;
	
}


