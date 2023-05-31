package com.tpssoft.accountingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpssoft.accountingservice.dto.TransactionDto;
import com.tpssoft.accountingservice.service.ITransactionService;

@RestController
@RequestMapping("api/v0/accounting")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService; 
	
	@PostMapping("/create-transaction")
	public ResponseEntity<String> createTransaction(@RequestBody TransactionDto transactionDto) {
		if (transactionService.createTransaction(transactionDto))
			return ResponseEntity.status(200).body("Create transaction Successful");
		return ResponseEntity.status(501).body("Create transaction Fail");
	}
}
