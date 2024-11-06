<%@page import="java.io.PrintWriter"%>
<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="com.org.modal.costumaerdetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
 <style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-image: url('');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}
.container {
    background-color: rgba(255, 255, 255, 0.9);
    padding: 10px;
    border-radius: 6px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    width: 350px;
     background: transparent; 
}
h2 {
    color: #333;
    margin-bottom: 24px;
    text-align: center;
}
form {
    display: flex;
    flex-direction: column;
}
input {
    margin-bottom: 12px;
    padding: 4px;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    background: transparent;
}
input[type="submit"] {
    background-color: #4CAF50;
    color: black;
    cursor: pointer;
    font-size: 14px;
    transition: background-color 0.3s ease;
    background: transparent;
}
input[type="submit"]:hover {
    background-color: lightgray;
}
input[placeholder]
{
   font-size: 16px;
}
</style>
<body>
    <div class="container">
        <h2>User Registration</h2>
        <form action="Registration.jsp" method="post">
            <input type="text" placeholder="Enter your Name " name="Name" required><br>
            <input type="email" placeholder="Enter your Email" name="Emalid" required><br>
           
            <input type="tel" placeholder="Enter your Phone Number" name="phonenumber" required><br>
            <input type="text" placeholder="Enter your Gender" name="Gender" required><br>
            <input type="tel" placeholder="Enter your Aadhar Number" name="Aadharn" required><br>
            <input type="text" placeholder="Enter your Address" name="Addres" required><br>
            <input type="text" placeholder="Enter your PAN Number" name="PAN" required><br>
            <input type="number" placeholder="Enter your Amount" name="Amount" required><br>
            <input type="submit" value="Register">
        </form>
    </div>
    
   <%/* PrintWriter out=response.getWriter(); */   
 String name=request.getParameter("Name");
       String Emalid=request.getParameter("Emalid");
       String Phonenumber=request.getParameter("phonenumber");
       long phonenumber=0;
       if(Phonenumber!=null && !Phonenumber.isEmpty()){
           try {
               phonenumber = Long.parseLong(Phonenumber);
           } catch (NumberFormatException e) {
               
               out.println("Invalid phone number format.");
               return; 
           }
       }
       
       String Gender=request.getParameter("Gender");
       String Aadhar=request.getParameter("Aadharn");
       long  AadharNumber=0;
       if( Aadhar!=null && !Aadhar.isEmpty()){
           try {
          	 AadharNumber   = Long.parseLong(Aadhar);
           } catch (NumberFormatException e) {
               
               out.println("Invalid Aadhar number format.");
               return; 
           }
       }
       String Addres=request.getParameter("Addres");
         String PAN=request.getParameter("PAN");
       String amount=request.getParameter("Amount");
       int Amount =0;
       if(amount!=null && !amount.isEmpty()){
      	 try {
          	Amount=Integer.parseInt(amount);
           } catch (NumberFormatException e) {
               
               out.println("Invalid Amount number format.");
               return; 
           }
       }
       
if(name!=null && Emalid!=null && Phonenumber!=null && Gender!=null && Aadhar!=null  && !Aadhar.isEmpty()&& Addres!=null && PAN!=null && amount!=null  ){
      
       costumaerdetails costumaerdetails= new costumaerdetails();
       costumaerdetails.setName(name);
       costumaerdetails.setEmalid(Emalid);
       costumaerdetails.setPhonenumber(phonenumber);
       costumaerdetails.setGender(Gender);
       costumaerdetails.setAadharNumber(AadharNumber);
       costumaerdetails.setAddress(Addres);
       costumaerdetails.setPannumber(PAN);
       costumaerdetails.setAmount(Amount);
       
       RegistrationDAO dao=new RegistrationDAOimpl();
      int details=dao.InsertIntoCustomerDetails(costumaerdetails);
       
       if(details!=0){
      	 RequestDispatcher dispatcher=request.getRequestDispatcher("userlogin.jsp");
      	 dispatcher.forward(request, response);
      	 
       }
       else{
      	/*  RequestDispatcher dispatcher=request.getRequestDispatcher("Registration.jsp");
      	 dispatcher.include(request, response); */%>
<%= "something wrong"%>

<%   }
  
}
 %>
    
    
    
    
</body>
