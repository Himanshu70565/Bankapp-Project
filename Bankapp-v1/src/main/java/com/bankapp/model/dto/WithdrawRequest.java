package com.bankapp.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawRequest {

	@NotNull(message = "from account number cant be null")
	private Integer fromAccount;

	@Min(value = 10, message = "minimum withdraw amount is 10")
	@NotNull(message = "withdraw amount cant be null")
	private Double amount;
}
