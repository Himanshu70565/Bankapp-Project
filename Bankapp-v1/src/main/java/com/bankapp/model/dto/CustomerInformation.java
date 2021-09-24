package com.bankapp.model.dto;

import javax.validation.constraints.Min;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerInformation {
	
	private Integer customerId;
	
	@NotEmpty(message = "customer name cant be empty")
	private String customerName;
	
	@NotEmpty(message = "customer email cant be empty")
	private String customerEmail;
	
	@Length(min = 10, max = 10, message = "enter valid 10 digit mobile number")
	@NotNull(message = "mobile number cant be null")
	private String customerPhone;
	
	@NotEmpty(message = "customer address field cant be empty")
	private String customerAddress;
	
	@Min(value = 100,message="minimum amount for account opening is 1000")
	private Double balance;
}
