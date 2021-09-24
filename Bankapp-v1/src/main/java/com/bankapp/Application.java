package com.bankapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.dao.TransactionDao;
import com.bankapp.model.dao.UserDao;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.entities.Customer;
import com.bankapp.web.entities.Transaction;
import com.bankapp.web.entities.User;

@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
@EnableTransactionManagement
@SpringBootApplication
public class Application implements CommandLineRunner {

	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TransactionDao transactionDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer c1 = new Customer("Himanshu", "him@gmail.com", "8708081736", "Yamunanagar");
		Account a1 = new Account(4000.0);
		c1.setAccount(a1);
		a1.setCustomer(c1);

		
		
		System.out.println(encoder.encode("raj123"));
		
//		List<Transaction> findByStatus = transactionDao.findByStatus("PENDING");
//		findByStatus.forEach(f->System.out.println(f));
//		List<Transaction> items = customerService.getCustomerById(1).getAccount().getTransactionList();
//		items.forEach(item->System.out.println(item));
//		
//		Account account = transactionService.getTransactionById(2).getAccount();
//		System.out.println(account);
//		Transaction tx1 = new Transaction(1, "WITHDRAW", 1000.0, "SUCCESS");
//		transactionService.addTransaction(tx1);
		

//		customerService.addCustomer(c1);
//		customerService.addCustomer(c1);
//		customerService.addCustomer(c1);

//		User user1=new User("raj", "raj@gmail.com", "raj123","90505056341","ROLE_ADMIN", 1250.0);
//		userService.addEmployee(user1);
//		List<User> allEmployees = userDao.findByProfile("ROLE_EMP");
//		allEmployees.forEach(e->System.out.println(e));
	}

}
