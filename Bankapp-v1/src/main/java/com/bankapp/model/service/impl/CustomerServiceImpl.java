package com.bankapp.model.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.CustomerDao;
import com.bankapp.model.service.CustomerService;
import com.bankapp.web.entities.Customer;
import com.bankapp.web.exceptions.CustomerNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerDao.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("customer with id : " + customerId + " not found"));
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		Customer customerToBeDeleted = getCustomerById(customerId);
		customerDao.delete(customerToBeDeleted);
		return customerToBeDeleted;
	}

	@Override
	public Customer updateCustomer(Integer customerId, String address) {
		Customer customerToBeUpdated = getCustomerById(customerId);
		customerToBeUpdated.setCustomerAddress(address);
		customerDao.save(customerToBeUpdated);
		return customerToBeUpdated;
	}

}
