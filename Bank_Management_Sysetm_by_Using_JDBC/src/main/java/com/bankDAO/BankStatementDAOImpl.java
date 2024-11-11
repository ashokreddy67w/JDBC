package com.bankDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bank_model.BankStatementdetails;
import java.sql.ResultSet;



public class BankStatementDAOImpl implements BankStatementDAO {
	private Connection Connection;
	private static final String url="jdbc:mysql://localhost:3306/taca62project?user=root&password=root";
	private static final String insert="insert into bank_statement ( Date_of_Transition, Time_of_Transition, Balance_Amount, Account_Number, Transition_Amount)values (?,?,?,?,?)";
	@Override
	public int insertBankStatements(BankStatementdetails BankStatementdetails) {
		try {
			 Connection=
			DriverManager.getConnection(url);
			PreparedStatement preparedStatement=Connection.prepareStatement(insert);
			preparedStatement.setDate(1,Date.valueOf(LocalDate.now()));
			preparedStatement.setTime(2,Time.valueOf(LocalTime.now()));
		    preparedStatement.setDouble(3,BankStatementdetails.getBalance_Amount());
		    preparedStatement.setLong(4,BankStatementdetails.getAccount_Number());
		    preparedStatement.setDouble(5,BankStatementdetails.getTransition_Amount());
			return preparedStatement.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public ResultSet bankManiStatement(BankStatementdetails bankStatementdetails) {
		String statement="select * from bank_statement  where Account_Number=?";
		
		try {
			Connection=
			DriverManager.getConnection(url);
			PreparedStatement preparedStatement=Connection.prepareStatement(statement);
			preparedStatement.setLong(1, bankStatementdetails.getAccount_Number());
			ResultSet resultset=preparedStatement.executeQuery();
		return 	resultset;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
		
	}
}
