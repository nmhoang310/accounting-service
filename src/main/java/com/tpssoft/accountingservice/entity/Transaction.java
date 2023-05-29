package com.tpssoft.accountingservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	private String transactionId;
	
	@Column
	private Double amount;
	@Column
	private Double fee;
	@Column
	private String category;
	@Column
	private String remitter;
	@Column
	private String beneficiary;
	@Column
	private Boolean status;
	@Column
	private String walletId;
	@Column
	private String cardId;
	@Column
	private String description;
	@Column
	private LocalDate transactionDate;
}
