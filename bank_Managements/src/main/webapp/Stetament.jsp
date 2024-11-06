<%@page import="com.org.modal.Transition"%>
<%@page import="com.org.DAO.RegistrationDAOimpl"%>
<%@page import="com.org.DAO.RegistrationDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.org.modal.costumaerdetails" %>
<%@page import ="java.sql.SQLException"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction Statement</title>
    <style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}
h1 {
    color: #333;
    text-align: center;
}
table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}
th, td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
th {
    background-color: #f2f2f2;
}
tr:hover {
    background-color: #f1f1f1;
}
a {
    display: inline-block;
    margin-top: 20px;
    color: #007bff;
    text-decoration: none;
    font-weight: bold;
}
a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>

<%
HttpSession Session = request.getSession();
costumaerdetails alluserdetails = (costumaerdetails) Session.getAttribute("alluserdetails");

long accountnumber = alluserdetails.getAccountnumber(); 
RegistrationDAO dao = new RegistrationDAOimpl();
ResultSet resultSet = dao.statement(accountnumber);

if (resultSet != null) { 
%>

<h1>Transaction Statement</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Account Number</th>
        <th>Transaction Amount</th>
        <th>Transaction Type</th>
        <th>Balance After Transaction</th>
        <th>Date of Transaction</th>
        <th>Time of Transaction</th>
    </tr>

    <%
try {
    while (resultSet.next()) {
%>
<tr>
    <td><%= resultSet.getInt("ID") %></td>
<td><%= resultSet.getLong("account_number") %></td>
<td><%= resultSet.getInt("Transaction_Amount") %></td>
<td><%= resultSet.getString("transactiontype") %></td>
<td><%= resultSet.getInt("balanceAfterTransaction") %></td>
<td><%= resultSet.getDate("DateofTransition") %></td>
<td><%= resultSet.getTime("TimeofTransition") %></td> 
</tr>
<%
    }
} catch (SQLException e) {
    e.printStackTrace();
}
%>
</table>
<a href="UserHome.jsp">Home Page</a>

<%
}
%>

</body>
</html>