package com.org.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

import java.time.LocalTime;

import javax.servlet.Registration;

import com.org.modal.admindetails;
import com.org.modal.costumaerdetails;
import com.org.modal.Transition;

public class RegistrationDAOimpl implements RegistrationDAO {
 
private static final String insertcos="insert into  bank_user_details  (Name, Emalid,Phonenumber, Aadhar_Number, Address, Amount, Gender,  IFSC_Number, Branch, Pan_number, Status) values(?,?,?,?,?,?,?,?,?,?,?)";

private static final String url="jdbc:mysql://localhost:3306/ashok?user=root&password=root";
private Connection connection;
@Override
public ResultSet adminlogin(String emalid ,String password){
	String adminlogin="select * from admin where  Admin_Emalid_id=? and Password=?";
try {
	Class.forName("com.mysal.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(adminlogin);
preparedStatement.setString(1, emalid);
preparedStatement.setString(2, password);
return preparedStatement.executeQuery();

} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
@Override
public int InsertIntoCustomerDetails(costumaerdetails costumaerdetails) {
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(insertcos);
//Name, Emalid,Phonenumber, Aadhar_Number, Address, Amount, Gender,  IFSC_Number, Branch, Pan_number, Status 
preparedStatement.setString(1, costumaerdetails.getName());
preparedStatement.setString(2, costumaerdetails.getEmalid());
preparedStatement.setLong(3, costumaerdetails.getPhonenumber());
preparedStatement.setLong(4, costumaerdetails.getAadharNumber());
preparedStatement.setString(5, costumaerdetails.getAddress());
preparedStatement.setInt(6, costumaerdetails.getAmount());
preparedStatement.setString(7, costumaerdetails.getGender());
preparedStatement.setString(8, "SBIN001");
preparedStatement.setString(9, "KPHB");
preparedStatement.setString(10, costumaerdetails.getPannumber());
preparedStatement.setString(11,"Pending");
return  preparedStatement.executeUpdate();

} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	
	
}
@Override
public costumaerdetails userlogin(costumaerdetails costumaerdetails) {
	String userlogin="select * from bank_user_details where Emalid=? and Pin=?";
//Name, Emalid,Phonenumber, Aadhar_Number, Address, Amount, Gender,  IFSC_Number, Branch, Pan_number, Status	
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection(url);
PreparedStatement preparedStatement= connection.prepareStatement(userlogin);
preparedStatement.setString(1,costumaerdetails.getEmalid());
preparedStatement.setInt(2, costumaerdetails.getPin());
ResultSet resultSet = preparedStatement.executeQuery();

if(resultSet.isBeforeFirst()) {
	
	if(resultSet.next()) {
		costumaerdetails costumaerdetails2=new costumaerdetails();
costumaerdetails2.setId(resultSet.getInt("ID"));
costumaerdetails2.setName(resultSet.getString("Name"));
costumaerdetails2.setEmalid(resultSet.getString("Emalid"));
costumaerdetails2.setPhonenumber(resultSet.getLong("Phonenumber"));
costumaerdetails2.setAadharNumber(resultSet.getLong("Aadhar_Number"));
costumaerdetails2.setPannumber(resultSet.getString("Pan_number"));
costumaerdetails2.setAddress(resultSet.getString("Address"));
costumaerdetails2.setAmount(resultSet.getInt("Amount"));
costumaerdetails2.setAccountnumber(resultSet.getLong("Account_Number"));
return costumaerdetails2;

//				System.out.println(costumaerdetails2);
				
			}
		
			
		}
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
		return null;
	}
	return costumaerdetails;
}


@Override
public ResultSet AllUserDetails() {
	String alluserdetails="select * from bank_user_details ";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(alluserdetails);
//ID, Name, Emalid, Pin, Phonenumber, Aadhar_Number, Address, Amount, Gender, Account_Number, IFSC_Number, Branch, Pan_number, Status

return preparedStatement.executeQuery();

} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
@Override
public ResultSet search(String search) {
	//ID, Name, Emalid, Pin, Phonenumber, Aadhar_Number, Address, Amount, Gender, Account_Number, IFSC_Number, Branch, Pan_number, Status
String search1= "select * from bank_user_details WHERE   Name LIKE ? OR Emalid LIKE ? OR Phonenumber LIKE ? OR Aadhar_Number LIKE ? OR Address LIKE ? OR Gender LIKE ? OR  Pan_number LIKE ? ";

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection(url);
if (search != null && !search.trim().isEmpty()) {
	PreparedStatement PreparedStatement=connection.prepareStatement(search1);
	String wildcardSearch =  search + "%";
		PreparedStatement.setString(1, wildcardSearch);
		PreparedStatement.setString(2, wildcardSearch);
		PreparedStatement.setString(3, wildcardSearch);
		PreparedStatement.setString(4, wildcardSearch);
		PreparedStatement.setString(5, wildcardSearch);
        PreparedStatement.setString(6, wildcardSearch);
        PreparedStatement.setString(7, wildcardSearch);
        
		return PreparedStatement.executeQuery();
	} else {
	return AllUserDetails();
	}
	
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
@Override
public ResultSet pending() {
	String pending="select * from bank_user_details where Account_Number is null";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(pending);

return preparedStatement.executeQuery();
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
@Override
public int Accountnumbercreat(costumaerdetails costumaerdetails) {
	String Accountnumber="update bank_user_details set  Account_Number=? ,pin=? ,Status= 'ACCEPTED' where Account_Number is null ";

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(Accountnumber);

preparedStatement.setLong(1, costumaerdetails.getAccountnumber());
preparedStatement.setInt(2, costumaerdetails.getPin());
return preparedStatement.executeUpdate();
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
		
	}
	
	
}
@Override
public int debitbyuseingAccountnumber(int Amount ,long Accountnumber) {
	String all="select * from bank_user_details ";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(all);

 ResultSet re = preparedStatement.executeQuery();
 
if(re.next()) {
int currentBalance = re.getInt("Amount");

String debit="update bank_user_details set Amount= Amount-? where Account_Number=?";
 preparedStatement=connection.prepareStatement(debit);
preparedStatement.setInt(1,Amount );
preparedStatement.setLong(2, Accountnumber);
 int result = preparedStatement.executeUpdate();


if(result!= 0) {
	int newBalance = currentBalance - Amount;
	//, Transaction_Amount, transactiontype, balanceAfterTransaction, account_number, DateofTransition, TimeofTransition
String transactionSql = "INSERT INTO transaction (account_number, Transaction_Amount, transactiontype, balanceAfterTransaction,DateofTransition,TimeofTransition) VALUES (?, ?, ?, ?, ?,?)";
 
     preparedStatement=connection.prepareStatement(transactionSql);
     preparedStatement.setLong(1, Accountnumber);
     preparedStatement.setInt(2, Amount);
     preparedStatement.setString(3, "DEBIT");
     preparedStatement.setDouble(4, newBalance);
     preparedStatement.setDate(5,Date.valueOf(LocalDate.now()));
	 preparedStatement.setTime(6,Time.valueOf(LocalTime.now()));
     
  return  preparedStatement.executeUpdate();
    
}}} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	return 0;
	
	
}
@Override
public int adminRegistration(admindetails admindetails) {
	//ID, Admin_Emalid_id, Password, Admin_Role
String admin="insert into admin (Admin_Emalid_id, Password, Admin_Role)values (?,?,?)";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(admin);
preparedStatement.setString(1,admindetails.getAdmin_Emalid_id());
preparedStatement.setString(2, admindetails.getPassword());
preparedStatement.setString(3, admindetails.getAdmin_Role());
return preparedStatement.executeUpdate();
} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	
}
@Override
public int creditbyuseingAccountnumber(int Amount ,long Accountnumber) {
	String all="select * from bank_user_details ";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(all);
 ResultSet re = preparedStatement.executeQuery();
 
if(re.next()) {
int currentBalance = re.getInt("Amount");

String debit="update bank_user_details set Amount=Amount+? where Account_Number=?";
preparedStatement=connection.prepareStatement(debit);
preparedStatement.setInt(1,Amount );
preparedStatement.setLong(2, Accountnumber);
 int result = preparedStatement.executeUpdate();


if(result!= 0) {
	int newBalance = currentBalance + Amount;
	//, Transaction_Amount, transactiontype, balanceAfterTransaction, account_number, DateofTransition, TimeofTransition
String transactionSql =  "INSERT INTO transaction (account_number, Transaction_Amount, transactiontype, balanceAfterTransaction,DateofTransition,TimeofTransition) VALUES (?, ?, ?, ?, ?,?)";

preparedStatement = connection.prepareStatement(transactionSql);
preparedStatement.setLong(1, Accountnumber);
preparedStatement.setInt(2, Amount);
preparedStatement.setString(3, "CREDIT");
		preparedStatement.setDouble(4, newBalance);
		preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
		preparedStatement.setTime(6, Time.valueOf(LocalTime.now()));
		

		return preparedStatement.executeUpdate();    
}}} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
	return 0;
	
	
}
@Override
public ResultSet statement(long accountnumber) {
	String Statement="select * from transaction where account_number=?";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement =connection.prepareStatement(Statement);
preparedStatement.setLong(1, accountnumber);
return preparedStatement.executeQuery();

} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	
}
@Override
public ResultSet checkBalance(long Accountnumber) {
	String checkBalance="select * from bank_user_details  where Account_Number=?";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
connection=	DriverManager.getConnection(url);
PreparedStatement preparedStatement=connection.prepareStatement(checkBalance);
preparedStatement.setLong(1, Accountnumber);
return preparedStatement.executeQuery();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	
	e.printStackTrace();
	return null;
} catch (SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}


}
