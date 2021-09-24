package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.exceptions.AccountNotFoundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.findAll();
	}

	@Override
	public Account getAccountById(Integer accountId) {
		return accountDao.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account with accountNumber :" + accountId + " not found"));
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.save(account);
	}

	@Override
	public Double getAccountBalance(Integer accountId) {
		Account account = getAccountById(accountId);
		return account.getAccountBalance();
	}

	@Override
	public Account updateAccount(Integer accountId, Double balance) {
		Account accountToBeUpdated = getAccountById(accountId);
		accountToBeUpdated.setAccountBalance(balance);
		accountDao.save(accountToBeUpdated);
		return accountToBeUpdated;
	}

}
