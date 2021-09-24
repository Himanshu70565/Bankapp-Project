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

import com.bankapp.model.service.UserService;
import com.bankapp.web.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/showAllEmployees")
	public String showAllEmployees(Model model) {
		model.addAttribute("employees", userService.getAllEmployees());
		return "showAllEmployees";
	}

	@GetMapping("/addEmployee")
	public String addEmployeeGet(Model model) {
		model.addAttribute("employee", new User());
		return "addEmployee";
	}
	
	@PostMapping("/addEmployee")
	public String addEmployeePost(@Valid @ModelAttribute(name="employee") User user,BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "addEmployee";
		}
	
		Integer userId=user.getUserId();
		if(userId==null) {
			//we have to add a new user
			userService.addEmployee(user);
		}else {
			//update employee
			userService.updateEmployee(userId, user.getSalary());
		}
	
		return "redirect:showAllEmployees";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam(name="id") int id) {
		userService.deleteEmployee(id);
		return "redirect:showAllEmployees";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam(name="id") int id,Model model) {
		model.addAttribute("employee", userService.getEmployeeById(id));
		return "updateEmployee";
	}
}
