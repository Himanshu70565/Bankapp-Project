package com.bankapp.model.service;

import java.util.List;

import com.bankapp.web.entities.User;

public interface UserService {

	public List<User> getAllEmployees();

	public User getEmployeeById(Integer employeeId);

	public User addEmployee(User user);

	public User deleteEmployee(Integer employeeId);

	public User updateEmployee(Integer employeeId, Double salary);

	public User findByUsername(String username);

	public User findByEmail(String email);
}
