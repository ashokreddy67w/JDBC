
package com.bank;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.bank.service.BankService;
import com.bank.service.CustomerRelationAssociater;
import com.bank.service.User_Exception;
public class App {
    public static void main(String[] args) throws User_Exception {
        Scanner scan = new Scanner(System.in);
        BankService bankService = CustomerRelationAssociater.CustomerService();
        System.out.print("+-----------------------------------------------------------------------------------------+\n");
 bankService.toSleep("|                             Welcome to Banking  Form                                    |\n");
System.out.print("+----------------------------------------------------------------------------------------+\n");
boolean bank=true;
try {
while(bank) {
bankService.toSleep("Enter \n1.For Banking Registration  \n2.For Banking LogIn");
     switch (scan.nextInt()) {
      case 1:
     System.out.print("+-----------------------------------------------------------------------------------------+\n");
     bankService.toSleep("|                                   Registration                                          |\n");
System.out.print("+-----------------------------------------------------------------------------------------+\n");
bankService.UserRegistration();
System.out.println("                              Do you want to continue?\n ");
      break;
 case 2:
	   System.out.print("+-----------------------------------------------------------------------------------------+\n");
bankService.toSleep("|                                     Login                                               |\n");
   System.out.print("+-----------------------------------------------------------------------------------------+\n");
   bankService.UserLogin();
   System.out.println("                               Do you want to continue?\n ");
    break;
default:
   	   System.out.print("+-----------------------------------------------------------------------------------------+\n");
bankService.toSleep("|                                invalid Selection                                        |\n");
   System.out.print("+-----------------------------------------------------------------------------------------+\n");
   System.out.println("                               Do you want to continue?\n ");
    break;
  }
  if( scan.next().equalsIgnoreCase("yes")) {
  }
}
}
catch(InputMismatchException e) {
 if( scan.next().equalsIgnoreCase("no")) {
   System.out.println("                            Thank you visit again");
			  } 
   }
    scan.close();         
    }
}   
