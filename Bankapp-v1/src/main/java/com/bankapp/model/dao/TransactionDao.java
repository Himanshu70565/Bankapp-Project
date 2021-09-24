package com.bankapp.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.web.entities.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{

	public List<Transaction> findByStatus(String status);

	public List<Transaction> findByFromAccountNumber(Integer fromAccountNumber);
	
	public List<Transaction> findByToAccountNumber(Integer toAccountNumber);
	
}
