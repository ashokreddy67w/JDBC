<%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import="com.org.modal.costumaerdetails"%>
<%@page import ="java.sql.ResultSet "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-image: url('https://images.unsplash.com/photo-1497864149936-d3163f0c0f4b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1920&q=80');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
}
.container {
    background-color: rgba(255, 255, 255, 0.9);
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
    width: 350px;
    background: transparent;
}
h2 {
    color: #333;
    margin-bottom: 1.5rem;
    text-align: center;
}
form {
    display: flex;
    flex-direction: column;
}
input {
    margin-bottom: 1rem;
    padding: 0.75rem;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    background: lightblue
    
}
button {
    background-color: #4267B2;
    color: white;
    padding: 0.75rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
}
button:hover {
    background-color: #365899;
}
.links {
    text-align: center;
    margin-top: 1rem;
}
.links a {
    color: #555;
    text-decoration: none;
    font-size: 14px;
    margin: 0 10px;
}
.links a:hover {
    text-decoration: underline;
}
.Admin-links {
    font-size: 12px;
    color: #777;
}
</style>
</head>
<body>
    <div class="container">
        <h2>User Login</h2>
        <form >
            <input type="email" name="user_emailid" placeholder="user Emalid" required>
            <input type="password" name="user_password" placeholder="User Password" required>
            <button type="submit">Log In</button>
        </form>

        <div class="links">
        <a href="User_Registration.html">Create New Acoount...? </a>
            <a href="#">Forgot Password?</a>   
        </div>
        <div class="links">
            <a href="Admin_Login.html" class="Admin-links">Admin Access</a>
        </div>
    </div>
    
   <%  String Emalid= request.getParameter("user_emailid");
 String pin=request.getParameter("user_password");
 
 if(Emalid!=null&& pin!=null){
int  Pin = Integer.parseInt(pin);
HttpSession Session=request.getSession();
costumaerdetails costumaerdetails= new costumaerdetails();
costumaerdetails.setEmalid(Emalid);
costumaerdetails.setPin(Pin);
     RegistrationDAO dao=new RegistrationDAOimpl();
     ResultSet resultset1=  dao.AllUserDetails();
     costumaerdetails alluserdetails= dao.userlogin(costumaerdetails);  
 if(alluserdetails!=null)
  {
 RequestDispatcher dispatcher=request.getRequestDispatcher("UserHome.jsp"); 

 dispatcher.forward(request, response);
 
 session.setAttribute("alluserdetails", alluserdetails);
 
 
  }
  else{%>
<%= "something wrong"%>
<% }}
%> 
    
    
    
    
    
</body>
</html>