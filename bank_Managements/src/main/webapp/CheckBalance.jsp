<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.org.modal.costumaerdetails" %>
<%@ page import="com.org.DAO.RegistrationDAOimpl" %>
<%@ page import="com.org.DAO.RegistrationDAO" %>
<%@page import="java.sql.ResultSet"%>
<%@ page import ="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check Balance</title>
    <style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}
h2 {
    color: #333;
}
#accountContainer {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: auto;
}
input[type="text"] {
    width: calc(100% - 22px);
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
}
input[type="button"], input[type="submit"] {
    background-color: #28a745;
    color: white;
    border: none;
    padding: 10px;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
}
input[type="button"]:hover, input[type="submit"]:hover {
    background-color: #218838;
}
table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
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
}
a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>

<%
costumaerdetails alluserdetails = (costumaerdetails) session.getAttribute("alluserdetails");
%>
<form id="accountContainer">
    <h2>Account number</h2>
    <input type="text" id="Accountnumber" readonly="readonly" value="<%= alluserdetails.getAccountnumber() %>" hidden="true">
<input type="text" id="useraccountNumber" name="accountNumber" placeholder="Enter Your Account number" required>
<input type="button" onclick="checkAccountnumber()" value="Submit">
</form>

<script type="text/javascript">
function checkAccountnumber() {
    var userAccountNumber = document.getElementById("Accountnumber").value;
    var accountNumber = document.getElementById("useraccountNumber").value;
    if (userAccountNumber === accountNumber) {
    	  document.getElementById("accountContainer").style.display = "none";
          document.getElementById("accountContainer").style.display = "block";
        document.getElementById("accountContainer").submit();
    } else {
        alert("Invalid Account number");
    }
}
</script>

<%
String accountNumber = request.getParameter("accountNumber");
if (accountNumber != null && !accountNumber.isEmpty()) {
    long account = Long.parseLong(accountNumber);
    RegistrationDAO dao = new RegistrationDAOimpl();
    ResultSet resultSet = dao.checkBalance(account);
    if (resultSet != null) {
%>
<h1>Statement</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Account Number</th>
        <th>Amount</th>
    </tr>
    <%
try {
    while (resultSet.next()) {
%>
<tr>
    <td><%= resultSet.getInt("ID") %></td>
<td><%= resultSet.getString("Name") %></td>
<td><%= resultSet.getLong("Account_Number") %></td>
<td><%= resultSet.getInt("Amount") %></td>
</tr>
<%
    }
} catch (SQLException e) {
    e.printStackTrace();
}
%>
</table>
<a href="UserHome.jsp">Home page</a>
<%
    }
}
%>

</body>
</html>