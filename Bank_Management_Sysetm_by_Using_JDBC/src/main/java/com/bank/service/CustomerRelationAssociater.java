package com.bank.service;

public class CustomerRelationAssociater {
	public static  BankService CustomerService() {
		return new BankServiceimpl();
	}

}
