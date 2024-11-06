<%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            text-align: center;
            margin-bottom: 20px;
        }

        input[type="text"] {
            padding: 10px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
        }

        input[type="submit"] {
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            background-color: #5cb85c;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #4cae4c;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #5cb85c;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<% 
PrintWriter writer = response.getWriter();
String searchQuery = request.getParameter("search");
RegistrationDAO dao = new RegistrationDAOimpl();
ResultSet resultSet = dao.search(searchQuery);
%>

<center>
    <h1>ALL USER DETAILS</h1>
    <form method="get" action="">
        <input type="text" name="search" placeholder="Search..." required />
        <input type="submit" value="Search" />
    </form>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Aadhaar Number</th>
            <th>Address</th>
            <th>Pan Number</th>
            <th>Gender</th>
        </tr>

        <%
        if (resultSet != null) {
            while (resultSet.next()) {
        %>
        <tr>
            <td><%= resultSet.getInt("ID") %></td>
            <td><%= resultSet.getString("Name") %></td>
            <td><%= resultSet.getString("Emalid") %></td>
            <td><%= resultSet.getLong("Phonenumber") %></td>
            <td><%= resultSet.getLong("Aadhar_Number") %></td>
            <td><%= resultSet.getString("Address") %></td>
            <td><%= resultSet.getString("Pan_number") %></td>
            <td><%= resultSet.getString("Gender") %></td>
        </tr>
        <%
            }
        }  %>
    </table>
</center>
</body>
</html>