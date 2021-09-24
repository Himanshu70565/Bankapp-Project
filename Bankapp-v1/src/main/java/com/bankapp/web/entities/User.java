package com.bankapp.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Length(min = 3,message = "enter username of atleast 3 character long")
	private String username;

	@NotEmpty(message = "please provide email")
	private String email;

	@Length(min = 5, message = "password must be atleast 5 character length")
	private String password;

	@Length(min = 10, max = 10, message = "enter valid 10 digit mobile number")
	@NotNull(message = "mobile number cant be null")
	private String phone;
	private String profile; // ADMIN , EMPL

	@NotNull(message = "enter salary of the employee")
	private Double salary;

	public User(String username, String email, String password, String phone, String profile, Double salary) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.profile = profile;
		this.salary = salary;
	}

}
