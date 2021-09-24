package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankapp.security.service.SecurityUser;

@Controller
public class WebController {
	@GetMapping(path = "login")
	public String login() {
		return "loginPage";
	}

	@GetMapping(path = "logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){   
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
		return "redirect:login?logout=success";
	}
	
	@GetMapping(path = "home")
	public String hello(Model model) {
		return "homePage";
	}
	
	@GetMapping(path = "accessdenied")
	public String handleAccessDenied(Model model,@AuthenticationPrincipal SecurityUser secUser) {
		model.addAttribute("user", secUser.getUser());
		return "403";
	}
	
}
