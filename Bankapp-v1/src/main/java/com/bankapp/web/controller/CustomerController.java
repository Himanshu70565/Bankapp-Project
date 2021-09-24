package com.bankapp.web.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankapp.model.dto.CustomerInformation;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.web.entities.Account;
import com.bankapp.web.entities.Customer;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

	private CustomerService customerService;
	private AccountService accountService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	// **********************************************
	@GetMapping("/showAllCustomer")
	public String getAllCustomer(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "showAllCustomers";
	}

	// ***********************************************
	@GetMapping("/addCustomer")
	public String addCustomerGet(Model model) {
		model.addAttribute("customer", new CustomerInformation());
		return "addCustomer";
	}

	// ***********************************************
	@PostMapping("/addCustomer")
	public String addCustomerPost(@Valid @ModelAttribute(name = "customer") CustomerInformation customerInformation,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addCustomer";
		}

		Customer customer = new Customer(customerInformation.getCustomerName(), customerInformation.getCustomerEmail(),
				customerInformation.getCustomerPhone(), customerInformation.getCustomerAddress());
		;
		Double balance = customerInformation.getBalance();
		System.out.println("***********");
		if(balance==null) {
			balance=0.0;
		}
		System.out.println("**********");

		Account account = new Account(balance);
		customer.setAccount(account);
		account.setCustomer(customer);

		customerService.addCustomer(customer);

		return "redirect:showAllCustomer";
	}

	// ************************************************
	@GetMapping("/updateCustomer")
	public String updateCustomerGet(@RequestParam(name = "id") int customerId, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(customerId));
		return "updateCustomer";
	}

	@PostMapping("/updateCustomer")
	public String updateCustomerPost(@Valid @ModelAttribute(name = "customer") CustomerInformation customerInformation,
			BindingResult result) {
		if (result.hasErrors()) {
			return "updateCustomer";
		}

		customerService.updateCustomer(customerInformation.getCustomerId(), customerInformation.getCustomerAddress());
		return "redirect:showAllCustomer";
	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam(name = "id") int customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:showAllCustomer";
	}

}
