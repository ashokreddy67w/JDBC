package com.bankDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.bank_model.bankconsumerdetails;
public class BankDAOImpl implements BankDAO {
private Connection connection;
private static final String url="jdbc:mysql://localhost:3306/taca62project?user=root&password=root";
private static final String Select="Select * from bank_consumer_details";
private static final String insert="INSERT INTO bank_consumer_details (Frist_Name, Last_Name, Email_id, Password,Phone_Number, Aadhar_Number, Gender, Address, Date_of_Birth, Account_Number, Amount)values (?,?,?,?,?,?,?,?,?,?,?)";
public List<bankconsumerdetails> getAllBankCostumarDetails() {
try {
	 connection=	DriverManager.getConnection(url);
	PreparedStatement pr=connection.prepareStatement(Select);
	ResultSet ResultSet=pr.executeQuery();
	List<bankconsumerdetails> listbankconsumerdetails=new ArrayList<bankconsumerdetails>();
	if(ResultSet.isBeforeFirst())
	{
		while(ResultSet.next()) {
bankconsumerdetails bankconsumerdetails=new bankconsumerdetails();
bankconsumerdetails.setAadhar_number(ResultSet.getLong("Aadhar_Number"));
bankconsumerdetails.setEmail_id(ResultSet.getString("Email_id"));
bankconsumerdetails.setPhone_number(ResultSet.getLong("Phone_Number"));
bankconsumerdetails.setPassword(ResultSet.getString("Password"));
				listbankconsumerdetails.add(bankconsumerdetails);
			}
			return listbankconsumerdetails;
		}
		else {
			return null;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	}
}
//INSERT INTO bank_consumer_details (Frist_Name, Last_Name, 
//		Email_id, Password,Phone_Number, Aadhar_Number, Gender, Address, Date_of_Birth, Account_Number, Amount)values (?,?,?,?,?,?,?,?,?,?,?)";
@Override
public int insertBankCosumardetails(bankconsumerdetails bankconsumerdetails) {
	try {connection =
		DriverManager.getConnection(url);
	PreparedStatement pr=connection.prepareStatement(insert);
	pr.setString(1,bankconsumerdetails.getFrist_name());
	pr.setString(2,bankconsumerdetails.getLast_name());
	pr.setString(3, bankconsumerdetails.getEmail_id());
	pr.setString(4,bankconsumerdetails.getPassword());
	pr.setLong(5,bankconsumerdetails.getPhone_number());
	pr.setLong(6, bankconsumerdetails.getAadhar_number());
	pr.setString(7, bankconsumerdetails.getGender());
	pr.setString(8, bankconsumerdetails.getAddress());
	LocalDate Date_of_Birth=bankconsumerdetails.getDate_of_birth();
	pr.setDate(9,Date.valueOf(Date_of_Birth));
	pr.setLong(10,bankconsumerdetails.getAccount_number());
	pr.setDouble(11,bankconsumerdetails.getAmount());
	return pr.executeUpdate();		  
			} catch (SQLException e) {			
			e.printStackTrace();
			return 0;
		}		
	}
@Override
public bankconsumerdetails getuserbyuseingemailidorphonenumberandpassword(String Emailidorphonenumber, String Password) {
      String Login="select * from bank_consumer_details where  (Email_id=? or Phone_Number=?) and Password=?";
try {
	connection=
	DriverManager.getConnection(url);
	PreparedStatement preparedStatement=connection.prepareStatement(Login);
	preparedStatement.setString(1, Emailidorphonenumber);
	preparedStatement.setString(2, Emailidorphonenumber);
	preparedStatement.setString(3,Password);
	ResultSet resultset=preparedStatement.executeQuery();
	if(resultset.next()) {
		bankconsumerdetails bankconsumerdetail=new bankconsumerdetails();
		bankconsumerdetail.setFrist_name(resultset.getString("Frist_Name"));
bankconsumerdetail.setLast_name(resultset.getString("Last_Name"));
bankconsumerdetail.setGender(resultset.getString("Gender"));
bankconsumerdetail.setAmount(resultset.getDouble("Amount"));
bankconsumerdetail.setAccount_number(resultset.getLong("Account_Number"));
		return bankconsumerdetail;
	}
	else {
		return null;
	}
	
} catch (SQLException e) {
		e.printStackTrace();
	    return null;
	}
}
@Override
public int updateAmounbyuseingAccountNumber(double Amount, long Account_Number) {
	String update="update bank_consumer_details set Amount=? where Account_Number=?";
try {
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(update);
preparedStatement.setDouble(1, Amount);
preparedStatement.setLong(2, Account_Number);
return preparedStatement.executeUpdate();
} catch (SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}
}



