package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bankapp.web.exceptions.AccountNotFoundException;
import com.bankapp.web.exceptions.NotSufficientBalanceException;


@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest request, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errorPage");
		mv.addObject("message", e.getMessage());
		return mv;
	}
	
	@ExceptionHandler(NotSufficientBalanceException.class)
	public ModelAndView handleMinimumBalance(HttpServletRequest request, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errorPage");
		mv.addObject("message", e.getMessage());
		return mv;
	}
	

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		mv.addObject("message", "resource is not found!!!!");
		return mv;

	}
}
