package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.TransactionDao;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.entities.Transaction;
import com.bankapp.web.exceptions.AccountNotFoundException;
import com.bankapp.web.exceptions.NotSufficientBalanceException;
import com.bankapp.web.exceptions.TransactionNotFoundException;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

	private AccountService accountService;
	private TransactionDao transactionDao;

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionDao.findAll();
	}

	@Override
	public Transaction getTransactionById(int transactionId) {
		return transactionDao.findById(transactionId).orElseThrow(
				() -> new TransactionNotFoundException("transaction with id : " + transactionId + " not found"));
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	public Transaction updateTransaction(int transactionId, String status) {
		Transaction transactionToBeUpdated = getTransactionById(transactionId);
		transactionToBeUpdated.setStatus(status);
		transactionDao.save(transactionToBeUpdated);
		return transactionToBeUpdated;
	}

	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class })
	public void depositMoney(Integer accountNumber, Double depositAmount) {
		Account account = accountService.getAccountById(accountNumber);
		Transaction transaction = new Transaction(null, accountNumber, "DEPOSIT", depositAmount, "SUCCESS");
		account.getTransactionList().add(transaction);
		transaction.setAccount(account);
		accountService.updateAccount(accountNumber, account.getAccountBalance() + depositAmount);
	}

	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class })
	public void withdrawMoney(Integer accountNumber, Double withdrawAmount) {

		Account account = accountService.getAccountById(accountNumber);
		if (account.getAccountBalance() >= withdrawAmount) {
			Transaction transaction = new Transaction(accountNumber, null, "WITHDRAW", withdrawAmount, "SUCCESS");
			transaction.setAccount(account);
			account.getTransactionList().add(transaction);
			accountService.updateAccount(accountNumber, account.getAccountBalance() - withdrawAmount);
		} else {
			throw new NotSufficientBalanceException("AccountNumber: " + accountNumber + " has not sufficient balance");
		}

	}

	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class })
	public void transferMoney(Integer fromAccountNumber, Integer toAccountNumber, Double amount) {

		Account fromAccount = accountService.getAccountById(fromAccountNumber);
		if (fromAccount.getAccountBalance() >= amount) {

			Account toAccount = accountService.getAccountById(toAccountNumber);

			if (amount >= 200000) {
				Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber, "TRANSFER", amount,
						"PENDING");
				transaction.setAccount(fromAccount);
				addTransaction(transaction);
			} else {
				Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber, "TRANSFER", amount,
						"SUCCESS");
				fromAccount.getTransactionList().add(transaction);
				accountService.updateAccount(fromAccountNumber, fromAccount.getAccountBalance() - amount);
				accountService.updateAccount(toAccountNumber, toAccount.getAccountBalance() + amount);
			}

		} else {
			throw new NotSufficientBalanceException(
					"accountNumber: " + fromAccountNumber + " has not sufficient balance");
		}

	}

	@Override
	public List<Transaction> getTransactionListByStatus(String status) {
		return transactionDao.findByStatus(status);
	}

	@Override
	@Transactional(rollbackOn = { AccountNotFoundException.class, NotSufficientBalanceException.class,TransactionNotFoundException.class })
	public void approvePendingTransaction(Integer transactionId) {
		Transaction transaction = getTransactionById(transactionId);
		Double amount = transaction.getAmount();

		Integer fromAccountNumber = transaction.getFromAccountNumber();
		Integer toAccountNumber = transaction.getToAccountNumber();

		Account fromAccount = accountService.getAccountById(fromAccountNumber);
		Account toAccount = accountService.getAccountById(toAccountNumber);

		if (fromAccount.getAccountBalance() >= amount) {
			accountService.updateAccount(fromAccountNumber, fromAccount.getAccountBalance() - amount);
			accountService.updateAccount(toAccountNumber, toAccount.getAccountBalance() + amount);
			transaction.setStatus("SUCCESS");
			addTransaction(transaction); //Not compulsory 
		} else {
			throw new NotSufficientBalanceException(
					"account with id : " + fromAccountNumber + " don't have sufficient balance");
		}

	}

	@Override
	public void rejectPendingTransaction(Integer transactionId) {
		Transaction transaction = getTransactionById(transactionId);
		transaction.setStatus("REJECTED");
		addTransaction(transaction);
	}

	@Override
	public List<Transaction> accountStatement(Integer accountNumber) {
		//withdraw
		List list1=transactionDao.findByFromAccountNumber(accountNumber);
		
		//deposit
		List list2=transactionDao.findByToAccountNumber(accountNumber);
		
		list1.addAll(list2);
		return list1;
	}

}
