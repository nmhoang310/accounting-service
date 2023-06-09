package com.tpssoft.accountingservice.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionDto {

	private String transactionId;

	private Double amount;

	private Double fee;

	private String category;
	
	private String beneficiary;

	private String remitter;

	private String status;

	private String walletId;

	private String cardId;

	private LocalDateTime transactionDate;
}
