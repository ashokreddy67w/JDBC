<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="com.org.modal.admindetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            text-align: center;
        }
        form {
            display: inline-block;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"], input[type="password"] {
            display: block;
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
    <form action="" method="post">
        <input placeholder="Enter Your Emalid" name="Emalid" type="text">
        <input placeholder="Enter your password" name="password" type="password">
        <input placeholder="Enter Your Role" name="Role" type="text">
        <input type="submit" value="Registration">
    </form>
    <% 
        String Emalid = request.getParameter("Emalid");
        String password = request.getParameter("password");
        String Role = request.getParameter("Role");
        if(Emalid!=null && password!=null && Role!=null){
        admindetails admindetails = new admindetails();
        admindetails.setAdmin_Emalid_id(Emalid);
        admindetails.setPassword(password);
        admindetails.setAdmin_Role(Role);
        RegistrationDAO dao = new RegistrationDAOimpl();
        int adminRegistration = dao.adminRegistration(admindetails);
        if (adminRegistration != 0) {
            out.print("Registration successful");
        } else {
            out.print("Registration failed");
        }
        }
    %>
</body>
</html>