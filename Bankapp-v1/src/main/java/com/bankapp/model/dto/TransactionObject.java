package com.bankapp.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
public class TransactionObject {

	@NotNull(message = "from account number can't be null")
	private Integer fromAccountNumber;

	@NotNull(message = "to account number can't be null")
	private Integer toAccountNumber;

	@NotNull(message = "amount can't be null")
	@Min(message = "Minimum amount is 100", value = 100)
	@Max(message = "Maximum amount is 1000000", value = 1000000)
	private Double amount;
}
