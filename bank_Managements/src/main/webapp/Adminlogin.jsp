
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import ="java.sql.ResultSet "%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
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
.login-container {
    background-color: rgba(255, 255, 255, 0.9);
    padding: 32px;
    border-radius: 8px;
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
    margin-bottom: 16px;
    padding: 0.75rem;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 14px;
    background: lightblue
    
    
}
button {
    background-color: #4267B2;
    color: white;
    padding: 12px;
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
.admin-link {
    font-size: 12px;
    color: #777;
}
</style>
</head>
<body>
<div class="login-container">
<h2>Admin Login</h2>
        <form action="Admin_login" method="post">
            <input type="email" name="Adminemail" placeholder="Emalid" required>
            <input type="password" name="Adminpassword" placeholder="password" required>
            <button type="submit">Log In</button>
        </form>
        <div class="links">
        <a href="Admin_Registration.html">Create New Acoount...? </a>
            <a href="#">Forgot Password?</a> 
        </div>
        <div class="links">
            <a href="User_Login.html" class="admin-link">User Login</a>
        </div>
    </div>
    
    
    <%String Adminemail=request.getParameter("Adminemail");
    String Adminpassword=request.getParameter("Adminpassword");
    
   if(Adminemail!=null && Adminpassword!=null ){
	   RegistrationDAO dao=new RegistrationDAOimpl();
	   ResultSet adminlogindetails=dao.adminlogin(Adminemail, Adminpassword);
	   if(adminlogindetails.next()){
		   
	   }
	   else{%>
		   <%= "invalid details" %>
	  <% }
   }
    
    
    %>
    
    
    
    
    
    
    
</body>
</html>