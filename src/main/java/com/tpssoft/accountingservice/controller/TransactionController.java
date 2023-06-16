package com.tpssoft.accountingservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpssoft.accountingservice.dto.TransactionDto;
import com.tpssoft.accountingservice.service.ITransactionService;

@RestController
@RequestMapping("api/v0/accounting")
//@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;

	@PostMapping("/create-transaction")
	public ResponseEntity<String> createTransaction(@RequestBody TransactionDto transactionDto) {
		if (transactionService.createTransaction(transactionDto))
			return ResponseEntity.status(200).body("Create transaction Successful");
		return ResponseEntity.status(501).body("Create transaction Fail");
	}

	@GetMapping("/transaction/{walletId}")
	public List<TransactionDto> getTransactionByWalletId(@PathVariable String walletId) {
		List<TransactionDto> result =  transactionService.getTransactionByWalletId(walletId);
		return result;
	}

	@GetMapping("/transaction/filter")
	public List<TransactionDto> getTransactionByDate(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end, @RequestParam String walletId) {
		List<TransactionDto> result =  transactionService.getTransactionByTransactionDate(start, end, walletId);
		return result;
	}
}
