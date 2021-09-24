package com.bankapp.model.service;

import java.util.*;

import com.bankapp.web.entities.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer getCustomerById(Integer customerId);

	public Customer addCustomer(Customer customer);

	public Customer deleteCustomer(Integer customerId);

	public Customer updateCustomer(Integer customerId, String address);

}
