package com.bankDAO;


import java.sql.ResultSet;

import com.bank_model.BankStatementdetails;
public interface BankStatementDAO {	
int insertBankStatements(BankStatementdetails BankStatementdetails);
ResultSet bankManiStatement(BankStatementdetails bankStatementdetails);
}
