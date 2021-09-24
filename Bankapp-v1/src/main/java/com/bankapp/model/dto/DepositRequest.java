package com.bankapp.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequest {

	@NotNull(message = "to account number can't be null")
	private Integer toAccount;

	@Min(value = 1, message = "minimum deposit amount is 1")
	@NotNull(message = "deposit amount can't be null")
	private Double amount;
}
