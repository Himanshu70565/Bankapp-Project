package com.bankapp.web.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer","transactionList"})
@Entity
@Table(name = "account_table")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;

	private Double accountBalance;

	@OneToOne(mappedBy = "account")
	private Customer customer;

	//New change in 3 
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER,cascade =CascadeType.MERGE)
	private List<Transaction> transactionList=new ArrayList<>();
	
	public Account(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
