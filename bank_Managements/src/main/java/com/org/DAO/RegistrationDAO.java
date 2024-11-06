package com.org.DAO;

import java.sql.ResultSet;

import javax.servlet.Registration;


import com.org.modal.admindetails;
import com.org.modal.costumaerdetails;

public interface RegistrationDAO {
	ResultSet adminlogin(String emalid ,String password);
int InsertIntoCustomerDetails(costumaerdetails costumaerdetails);
costumaerdetails userlogin(costumaerdetails costumaerdetails);

ResultSet AllUserDetails();
ResultSet search(String search);
ResultSet pending();
int Accountnumbercreat(costumaerdetails costumaerdetails);
int debitbyuseingAccountnumber(int Amount ,long Accountnumber);
int adminRegistration(admindetails admindetails);
int creditbyuseingAccountnumber(int Amount ,long Accountnumber);
ResultSet statement(long accountnumber);
ResultSet checkBalance(long Accountnumber);

}
