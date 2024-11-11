package com.bank_model;

import java.time.LocalDate;
import java.time.LocalTime;
public class BankStatementdetails {
	private int id;
	private LocalDate Date_of_Transition;
	private LocalTime Time_of_Transition;
	private double Balance_Amount;
	private long Account_Number;
	private double Transition_Amount;
	public BankStatementdetails(){	
	}
	public BankStatementdetails(int id, LocalDate date_of_Transition, LocalTime time_of_Transition,
			double balance_Amount, long account_Number, double transition_Amount) {
		super();
		this.id = id;
		Date_of_Transition = date_of_Transition;
		Time_of_Transition = time_of_Transition;
		Balance_Amount = balance_Amount;
		Account_Number = account_Number;
		Transition_Amount = transition_Amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate_of_Transition() {
		return Date_of_Transition;
	}
	public void setDate_of_Transition(LocalDate date_of_Transition) {
		Date_of_Transition = date_of_Transition;
	}
	public LocalTime getTime_of_Transition() {
		return Time_of_Transition;
	}
	public void setTime_of_Transition(LocalTime time_of_Transition) {
		Time_of_Transition = time_of_Transition;
	}
	public double getBalance_Amount() {
		return Balance_Amount;
	}
	public void setBalance_Amount(double balance_Amount) {
		Balance_Amount = balance_Amount;
	}
	public long getAccount_Number() {
		return Account_Number;
	}
	public void setAccount_Number(long account_Number) {
		Account_Number = account_Number;
	}
	public double getTransition_Amount() {
		return Transition_Amount;
	}
	public void setTransition_Amount(double transition_Amount) {
		Transition_Amount = transition_Amount;
	}
	@Override
	public String toString() {
		return "BankStatementdetails [id=" + id + ", Date_of_Transition=" + Date_of_Transition + ", Time_of_Transition="
	+ Time_of_Transition + ", Balance_Amount=" + Balance_Amount + ", Account_Number=" + Account_Number
	+ ", Transition_Amount=" + Transition_Amount + "]";
	}	
}
