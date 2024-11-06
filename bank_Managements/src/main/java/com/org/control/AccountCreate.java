package com.org.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.DAO.RegistrationDAO;
import com.org.DAO.RegistrationDAOimpl;
import com.org.modal.costumaerdetails;
@WebServlet("/AccountCreate")
public class AccountCreate  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("ID");
		int ID = Integer.parseInt(Id);
		Random random=new Random();
		int pin=random.nextInt(9000)+1000;
		
		long  Account = 10000000000L + random.nextInt(900000000);
		costumaerdetails costumaerdetails=new costumaerdetails();
		costumaerdetails.setId(ID);
		costumaerdetails.setAccountnumber(Account);
		costumaerdetails.setPin(pin);
		RegistrationDAO dao=new RegistrationDAOimpl();
		
		int accountnumbercreat = dao.Accountnumbercreat(costumaerdetails);
		if(accountnumbercreat!=0) {
			
		}else {
			
		}
		
	}

}
