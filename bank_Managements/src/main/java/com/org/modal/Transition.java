package com.org.modal;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transition {
    private int transactionId;
    private long accountNumber;
    private int amount;
    private int balanceAfterTransaction;
    private String transactionType;
    private LocalDate DateofTransition;
	private LocalTime TimeofTransition;
    
    

}
