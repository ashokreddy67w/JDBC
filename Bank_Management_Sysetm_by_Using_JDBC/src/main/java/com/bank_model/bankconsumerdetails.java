package com.bank_model;

import java.time.LocalDate;

public class bankconsumerdetails {
	
private int consumer_id;
private String frist_name;
private String last_name;
private String  email_id;
private String password;
private long phone_number;
private long aadhar_number;
private String gender;
private String address;
private LocalDate date_of_birth;
private  long account_number;
private double Amount;
public bankconsumerdetails() {
	
}
public bankconsumerdetails(int consumer_id, String frist_name, String last_name, String email_id, String password,
		long phone_number, long aadhar_number, String gender, String address, LocalDate date_of_birth,
		long account_number, double amount) {
	super();
	this.consumer_id = consumer_id;
	this.frist_name = frist_name;
	this.last_name = last_name;
	this.email_id = email_id;
	this.password = password;
	this.phone_number = phone_number;
	this.aadhar_number = aadhar_number;
	this.gender = gender;
	this.address = address;
	this.date_of_birth = date_of_birth;
	this.account_number = account_number;
	Amount = amount;
}
public int getConsumer_id() {
	return consumer_id;
}
public void setConsumer_id(int consumer_id) {
	this.consumer_id = consumer_id;
}
public String getFrist_name() {
	return frist_name;
}
public void setFrist_name(String frist_name) {
	this.frist_name = frist_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public  String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getPhone_number() {
	return phone_number;
}
public void setPhone_number(long phone_number) {
	this.phone_number = phone_number;
}
public long getAadhar_number() {
	return aadhar_number;
}
public void setAadhar_number(long aadhar_number) {
	this.aadhar_number = aadhar_number;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public LocalDate getDate_of_birth() {
	return date_of_birth;
}
public void setDate_of_birth(LocalDate date_of_birth) {
	this.date_of_birth = date_of_birth;
}
public long getAccount_number() {
	return account_number;
}
public void setAccount_number(long account_number) {
	this.account_number = account_number;
}
public double getAmount() {
	return Amount;
}
public void setAmount(double amount) {
	Amount = amount;
}

}
