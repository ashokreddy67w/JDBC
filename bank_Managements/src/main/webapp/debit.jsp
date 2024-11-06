<%@ page import="com.org.modal.costumaerdetails" %>
<%@ page import="com.org.DAO.RegistrationDAOimpl" %>
<%@ page import="com.org.DAO.RegistrationDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Debit Operation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        #amountContainer, #accountContainer {
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
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<h2>Debit Operation</h2>
<%
    costumaerdetails alluserdetails = (costumaerdetails) session.getAttribute("alluserdetails");
    if (alluserdetails == null) {
        response.sendRedirect("User Home.jsp");
        return;
    }
%>
<form id="amountContainer">
    <h2>Amount</h2>
    <input type="text" id="debitAmount" name="dbAmount"
           value="<%= alluserdetails.getAmount() %>" readonly="readonly" hidden="true">
    <input type="text" placeholder="Enter your amount" name="Amount" id="useramount">
    <input type="button" onclick="CheckAmount()" value="Submit">
</form>
<form id="accountContainer" action="debit.jsp" method="post" style="display:none" >
    <h2>Account number</h2>
    <input type="hidden" name="Amount" id="transferAmount" hidden="true">
    <input type="text" id="Accountnumber" readonly="readonly"
           value="<%= alluserdetails.getAccountnumber() %>">
    <input type="text" id="useraccountNumber" name="accountNumber" 
           placeholder="Enter Your Account number">
    <input type="button" onclick="checkAccountnumber()" value="Submit">
</form>
<script type="text/javascript">
function CheckAmount() {
    var dbAmount = Number(document.getElementById("debitAmount").value);
    var money = Number(document.getElementById("useramount").value);
    
    if (money >= 0) {
        if (money <= dbAmount) {
            document.getElementById("transferAmount").value = money;
            document.getElementById("amountContainer").style.display = "none";
            document.getElementById("accountContainer").style.display = "block";
        } else {
            alert("Insufficient balance");
        }
    } else {
        alert("Invalid Amount");
    }
}

function checkAccountnumber(){
    var useraccountNumber = document.getElementById("useraccountNumber").value;
    var accountNumber = document.getElementById("Accountnumber").value;
    
    if (useraccountNumber == accountNumber) {
        document.getElementById("accountContainer").submit();
    } else {
        alert("Invalid Account number");
    }
}
</script>
<%
    String Amount = request.getParameter("Amount");
    String accountNumber = request.getParameter("accountNumber");

    if (Amount != null && accountNumber != null) {
        try {
            int amount = Integer.parseInt(Amount);
            long account = Long.parseLong(accountNumber);
            RegistrationDAO dao = new RegistrationDAOimpl();
            int debit = dao.debitbyuseingAccountnumber(amount, account );
            if (debit != 0) { 
                alluserdetails.setAmount(alluserdetails.getAmount() - amount);
                session.setAttribute("alluserdetails", alluserdetails);
                response.sendRedirect("UserHome.jsp");
                return;
            } else {
                response.sendRedirect("debit.jsp");
                return;
            }
        } catch (NumberFormatException e) {
            
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
%> 
</body>
</html>