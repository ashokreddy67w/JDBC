<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pending Registrations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
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
    RegistrationDAO dao = new RegistrationDAOimpl();
    ResultSet resultset = dao.pending();
    if (resultset.isBeforeFirst()) { 
%>
<table border="2">
   <tr>
       <th>Name</th>
       <th>Email</th>
       <th>Phone Number</th>
       <th>Aadhaar Number</th>
       <th>Address</th>
       <th>Gender</th>
       <th>Pan Number</th> 
   </tr>
   <% while (resultset.next()) { %>
   <tr>
       <td><%= resultset.getString("Name") %></td>
       <td><%= resultset.getString("Emalid") %></td>
       <td><%= resultset.getLong("Phonenumber") %></td>
       <td><%= resultset.getLong("Aadhar_Number") %></td>
       <td><%= resultset.getString("Address") %></td>
       <td><%= resultset.getString("Gender") %></td>
       <td><%= resultset.getString("Pan_number") %></td>
       <td>
           <form action="AccountCreate" method="post">
               <input name="ID" value="<%= resultset.getInt("ID") %>" type="hidden">
               <input type="submit" value="Accept">
           </form>
       </td>
   </tr>
   <% } %>
</table>
<% } else { %>
    <p>No pending registrations found.</p>
<% } %>

</body>
</html>