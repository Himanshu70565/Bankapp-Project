package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankapp.model.dto.DepositRequest;
import com.bankapp.model.dto.TransactionObject;
import com.bankapp.model.dto.WithdrawRequest;
import com.bankapp.model.service.TransactionService;
import com.bankapp.security.service.SecurityUser;
import com.bankapp.web.entities.Transaction;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	private TransactionService transactionService;

	@Autowired
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("showAllTransactions")
	public String getAllTransaction(Model model) {
		model.addAttribute("transactions", transactionService.getAllTransactions());
		return "showAllTransactions";
	}

	@GetMapping("/pendingTransaction")
	public String getAllPendingTransaction(Model model, @AuthenticationPrincipal SecurityUser secUser) {
		model.addAttribute("profile", secUser.getUser().getProfile());
		model.addAttribute("transactions", transactionService.getTransactionListByStatus("PENDING"));
		return "pendingTransaction";
	}

	@GetMapping("/approveTransaction")
	public String approveTransaction(@RequestParam(name = "id") Integer transactionId) {
		transactionService.approvePendingTransaction(transactionId);
		return "redirect:showAllTransactions";
	}

	@GetMapping("/rejectTransaction")
	public String rejectTransaction(@RequestParam(name = "id") Integer transactionId) {
		transactionService.rejectPendingTransaction(transactionId);
		return "redirect:showAllTransactions";
	}

	@GetMapping("/withdrawMoney")
	public String withdrawMoneyGet(Model model) {
		model.addAttribute("withdrawRequest", new WithdrawRequest());
		return "withdraw";
	}

	@PostMapping("/withdrawMoney")
	public String withdrawMoneyPost(@Valid @ModelAttribute WithdrawRequest withdrawRequest, BindingResult result) {
		if (result.hasErrors()) {
			return "withdraw";
		}
		Integer fromAccountNumber = withdrawRequest.getFromAccount();
		Double withdrawAmount = withdrawRequest.getAmount();
		transactionService.withdrawMoney(fromAccountNumber, withdrawAmount);
		return "redirect:showAllTransactions";
	}

	@GetMapping("depositMoney")
	public String depositMoneyGet(Model model) {
		model.addAttribute("depositRequest", new DepositRequest());
		return "deposit";
	}

	@PostMapping("depositMoney")
	public String depositMoneyPost(@Valid @ModelAttribute DepositRequest depositRequest, BindingResult result) {
		if (result.hasErrors()) {
			return "deposit";
		}
		Integer toAccountNumber = depositRequest.getToAccount();
		Double depositAmount = depositRequest.getAmount();

		transactionService.depositMoney(toAccountNumber, depositAmount);

		return "redirect:showAllTransactions";
	}

	@GetMapping("/transferMoney")
	public String transferMoneyGet(Model model) {
		model.addAttribute("transactionObject", new TransactionObject());
		return "transfer";
	}

	@PostMapping("/transferMoney")
	public String transferMoneyPost(@Valid @ModelAttribute TransactionObject tx, BindingResult result) {
		if (result.hasErrors()) {
			return "transfer";
		}
		Integer fromAccountNumber = tx.getFromAccountNumber();
		Integer toAccountNumber = tx.getToAccountNumber();
		Double amount = tx.getAmount();

		transactionService.transferMoney(fromAccountNumber, toAccountNumber, amount);

		return "redirect:showAllTransactions";
	}

	@GetMapping("/accountStatement")
	public String getAccountStatement(@RequestParam(name = "id") int id, Model model) {
		List<Transaction> accountStatement = transactionService.accountStatement(id);
		model.addAttribute("transactions", accountStatement);
		return "showAllTransactions";
	}
}
