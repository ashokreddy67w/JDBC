package com.bank.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bankDAO.BankDAO;
import com.bankDAO.BankDAOImpl;
import com.bankDAO.BankStatementDAO;
import com.bankDAO.BankStatementDAOImpl;
import com.bank_model.BankStatementdetails;
import com.bank_model.bankconsumerdetails;
public class BankServiceimpl implements BankService {
	BankDAO bankDAO = new BankDAOImpl();
	List<bankconsumerdetails> allBankCostumarDetails = bankDAO.getAllBankCostumarDetails();
	BankStatementDAO BankStatementDAO=new BankStatementDAOImpl();
	BankStatementdetails BankStatementdetails =new BankStatementdetails();	
	Scanner Scan=new Scanner(System.in);
	bankconsumerdetails logindetails;
	@Override
	public void toSleep(String Name) {
		// TODO Auto-generated method stub
for(int i=0;i<Name.length();i++)
{
	System.out.print(Name.charAt(i));
	try {
		Thread.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
}
@Override
public void UserRegistration() throws User_Exception {	
bankconsumerdetails bankconsumerdetails=new bankconsumerdetails();

System.out.print("Enter Your First Name                                    :");
String Frist_Name=Scan.next();
bankconsumerdetails.setFrist_name(Frist_Name);
System.out.print("Enter Your last Name                                     :");
String	Last_Name=Scan.next();
bankconsumerdetails.setLast_name(Last_Name);

boolean Email_idStatus = true;
while(Email_idStatus) {
    System.out.println("Enter Your Email Id:");
String Email_id = Scan.next();
bankconsumerdetails.setEmail_id(Email_id);
if(Email_id.endsWith("@gmail.com")){
boolean checkEmail_id = false;
for(bankconsumerdetails bankconsumerdetails1 :allBankCostumarDetails ){
if(bankconsumerdetails1.getEmail_id().equalsIgnoreCase(Email_id)) {
        checkEmail_id = true;
        break;
    }
}
if(checkEmail_id) { 
	  System.out.println("email id already in used. Please try again.");
	  checkEmail_id=true;	
    }
    else {
    	Email_idStatus=false;
    }
} else {
    throw new User_Exception("Invalid Email Id. Please try again");		
    } 
}
boolean PasswordStatus =true;
while(PasswordStatus)
{
System.out.println("Enter Your Password                                  :");
String Password=Scan.next();
if(Password.length()==4) {
	boolean checkPassword=false;
	for(bankconsumerdetails bankconsumerdetails1:allBankCostumarDetails ) {
		if(bankconsumerdetails1.getPassword().equalsIgnoreCase(Password)) {
			checkPassword=true;
		}
	}
		if(checkPassword)
		{System.out.println("password already in used.Please try again.");
		PasswordStatus=true;
		}
		else {
			PasswordStatus=	false;
System.out.println("Enter Confirm Your Password :  ");
String	Confirm_Password=Scan.next();

if (Password.equals(Confirm_Password)) {
bankconsumerdetails.setPassword(Password);
	break;
}
else {
throw new User_Exception("Password or confirm password is incorrect. Please try again.");
		}
		}	
}
}
boolean phone_numberStatus=true;
while(phone_numberStatus){
	System.out.println("Enter Your Phone Number                         :");
	long Phone_Number=Scan.nextLong();
	bankconsumerdetails.setPhone_number(Phone_Number);
	long temp1 = Phone_Number;
	  int count1 = 0;
	  while (temp1 != 0) {
		  count1++;
	      temp1 /= 10; 
	  }
if(Phone_Number>=6000000001L && Phone_Number<=9999999991l  &&count1==10  ) {
	boolean checkphonenumber=false;
	for(bankconsumerdetails bankconsumerdetails1:allBankCostumarDetails) {
		if(bankconsumerdetails1.getPhone_number()==Phone_Number) {
			checkphonenumber=true;
			break;
		}
	}
		if(checkphonenumber) {
			System.out.println("phone number already used");
			checkphonenumber=true;
		}
		else {
			phone_numberStatus=false;
		}
	}
else {
throw new User_Exception("Phone_Number incorrect. Please try again.");
}
} 
boolean Aadhar_NumberStatus=true;
while(Aadhar_NumberStatus) {
System.out.print("Enter your Aadhar number                         :");
 long Aadhar_Number=Scan.nextLong();
 bankconsumerdetails.setAadhar_number(Aadhar_Number);
  long temp = Aadhar_Number;
  int count = 0;
  while (temp != 0) {
	  count++;
      temp /= 10;   
  }
  if(count==12)
  {
	  boolean checkAadhar_Number=false;
		for(bankconsumerdetails bankconsumerdetails1:allBankCostumarDetails) {
			if(bankconsumerdetails1.getAadhar_number()==Aadhar_Number) {
				checkAadhar_Number=true;	
			}	
			}
			if(checkAadhar_Number) {
				System.out.println("aadhar number already used");
				checkAadhar_Number=true;
			}
			else {
				
Aadhar_NumberStatus=false;
				break;
			} 
  }
  else {
  throw new User_Exception("InValid Aadhaar number Try  again:");
  }  
      }

while(true)
{
	 System.out.print("Enter your Gender                               :");
 String Gender=Scan.next();
 bankconsumerdetails.setGender(Gender);
 if(Gender.equalsIgnoreCase("Male")||Gender.equalsIgnoreCase("Female")||Gender.equalsIgnoreCase("Transgender")) {
	 break;
 }
 else {
 throw new User_Exception("Invalid Gender  Try  again:");
	 }
	}
while(true) {
	System.out.print("Enter your Address                              :");
	String Address=Scan.next();
	bankconsumerdetails.setAddress(Address);
	break;
}
while (true) {
	System.out.println("Enter your Date of Birth");
	String Date_of_Birth=Scan.next();
	bankconsumerdetails.setDate_of_birth(LocalDate.parse(Date_of_Birth));
	break;
}
while(true) {
	System.out.print("Enter your Amount                               :");
		double Amount=Scan.nextDouble();
		bankconsumerdetails.setAmount(Amount);
		break;
	}
while(true) {
	Random random =new Random();
	int AccountNumber=random.nextInt();
	bankconsumerdetails.setAccount_number(AccountNumber);
	if(AccountNumber<10000000) {
		AccountNumber+=1000000;
		break;
	}
}
int cosumardetails= bankDAO.insertBankCosumardetails(bankconsumerdetails);
if(cosumardetails!=0) {
	System.out.println("Registration successfully");	
}
else {
	System.out.println("servser Error 500");
}
}
@Override
public void UserLogin() { 
System.out.println("Enter Your Emaild or phone number:  ");
String Emailidorphonenumber=Scan.next();
System.out.print("Enter your password:  ");
String Password=Scan.next();
Random random = new Random();
int optInCode = random.nextInt(9000) + 1000; 
System.out.println("Your 4-digit opt-in code is:"+ optInCode);
System.out.println("Enter Your OTP Number");
if(optInCode==Scan.nextInt()) {	
	logindetails=bankDAO.getuserbyuseingemailidorphonenumberandpassword(Emailidorphonenumber, Password);

if(logindetails!=null ) {
	
			if(logindetails.getGender().equalsIgnoreCase("male"))
{
	toSleep("Hello Mr "+logindetails.getFrist_name()+" "+logindetails.getLast_name());
}
if(logindetails.getGender().equalsIgnoreCase("Female"))
{
	toSleep("Hello Ms "+logindetails.getFrist_name()+" "+logindetails.getLast_name());
}
if(logindetails.getGender().equalsIgnoreCase("Transgender"))
{
	toSleep("Hello MR Tran "+logindetails.getFrist_name()+" "+logindetails.getLast_name());
	}
	userfunctionailties();
	
	}
else {
	System.out.println("Invalid details. Please try again.");
}  
}
else {
	
	System.out.println("Invalid otp. .");
    } 
  }
@Override
public void userfunctionailties() {
	boolean Status=true;
	while(Status) {
	System.out.println("\nEnter\n1.For Credit\n2.For Dedit\n3.For Check Balance\n4.For Check Stetament");
switch (Scan.nextInt()) {
case 1:
	System.out.println("Credit");
	Credit();
	break;
case 2:
	System.out.println("Dedit");
	Dedit();
	break;
case 3:
	System.out.println("Check Balance");
	check_Balance();
	break;
case 4:
	System.out.println("Check Stetament");
	Check_Stetament();
	break;
default:
	System.out.println("invalid Option");
	break;
}
System.out.println("Do You Want continue.....?Yes/No");
if(Scan.next().equalsIgnoreCase("Yes")) {
	
}
else {
	System.out.println("Thank you ");
		Status =false;
	}
}
}

@Override
public void Dedit() {
	System.out.println("Enter Amount");
double Debitamount=Scan.nextDouble();
if(Debitamount>0) {
	double Datebaseaount=logindetails.getAmount();
	if(Datebaseaount>=Debitamount) {
	double sub=Datebaseaount-Debitamount;
	long Account_Number=logindetails.getAccount_number();
	if(bankDAO.updateAmounbyuseingAccountNumber(sub, Account_Number)!=0) {
	logindetails.setAmount(sub);
	BankStatementdetails.setAccount_Number(Account_Number);
	BankStatementdetails.setTransition_Amount(Debitamount);
	BankStatementdetails.setBalance_Amount(sub);
	BankStatementDAO.insertBankStatements(BankStatementdetails);
 System.out.println("Amount Debited Successfully");
 System.out.println(" Do you want to know Balance.......? ");
 if(Scan.next().equalsIgnoreCase("yes")) {
 System.out.println("Your Balance  ="+sub); 
 }
}else {
	System.out.println("In-sefficient Balance");
	}
	
	
}
	else {
		System.out.println("In-sefficient Balance");
	}
}
else {
	System.out.println("Invalid Amount");
}
}
@Override
public void Credit() {
	System.out.println("Enter Amount");
	double creditamount=Scan.nextDouble();
	if(creditamount>=1) {
		double Datebaseaount=logindetails.getAmount();
		double add=Datebaseaount+creditamount;
		long Account_Number=logindetails.getAccount_number();
if(bankDAO.updateAmounbyuseingAccountNumber(add, Account_Number)!=0) {
	logindetails.setAmount(add);
		BankStatementdetails.setAccount_Number(Account_Number);
		BankStatementdetails.setTransition_Amount(creditamount);
		BankStatementdetails.setBalance_Amount(add);
		BankStatementDAO.insertBankStatements(BankStatementdetails);
		System.out.println("Amount Credited Successfully");
 System.out.println(" Do you want to know Balance  Amount.......? ");
 if(Scan.next().equalsIgnoreCase("yes")) {
 System.out.println("Your Balance  ="+add); 
     }
	}	
}
	else {
	System.out.println("Invalid Amount");
	}
}
@Override
public void check_Balance() {
	double Balance=logindetails.getAmount();
	System.out.println(Balance);
	
}

@Override
public void Check_Stetament() {
	BankStatementdetails bankStatementdetails=new BankStatementdetails();
	bankStatementdetails.setAccount_Number(logindetails.getAccount_number());
	ResultSet re =BankStatementDAO.bankManiStatement(bankStatementdetails);
	try {
		if(re.isBeforeFirst()) {
			while(re.next()) {
				System.out.println("");
  System.out.print("+-----------------------------------------------------------------------------------------+\n");
  System.out.println("Account number"+re.getLong("Account_Number"));
  System.out.println("Transition_Amount"+re.getDouble("Transition_Amount"));
  System.out.println("Date_of_Transition"+re.getDate("Date_of_Transition"));
  System.out.println("Time_of_Transition"+re.getTime("Time_of_Transition"));
  System.out.println("Balance_Amount"+re.getDouble("Balance_Amount"));
  System.out.print("+-----------------------------------------------------------------------------------------+\n");
  System.out.println("");
	}
}
else {
	System.out.println("no Transition....");
		}
	}catch(SQLException e) {
		
	}

	
	
}
}



