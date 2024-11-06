<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.org.modal.costumaerdetails" %>
<%@ page import="com.org.DAO.RegistrationDAOimpl" %>
<%@ page import="com.org.DAO.RegistrationDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit Operation</title>
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
    form {
        background: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="button"] {
        background-color: #5cb85c;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="button"]:hover {
        background-color: #4cae4c;
    }
</style>
</head>
<body>
    <h2>Credit Operation</h2>
    <%
    costumaerdetails alluserdetails = (costumaerdetails)session.getAttribute("alluserdetails");
    if(alluserdetails == null){
        response.sendRedirect("User Home.jsp");
        return;
    }
    %>
    <form id="amountContainer">
        <h2>Amount</h2>
        <input type="text" id="creditAmount" name="dbAmount" hidden="true"
               value="<%=alluserdetails.getAmount()%>" readonly="readonly"> 
        <input type="text" placeholder="Enter your amount" name="Amount" id="useramount">
        <input type="button" onclick="CheckAmount()" value="Submit">
    </form>
    <form id="accountContainer"  style="display: none">
        <h2>Account number</h2>
        <input type="hidden" name="Amount" id="transferAmount">
        <input type="text" id="Accountnumber" readonly
               value="<%=alluserdetails.getAccountnumber()%>">
        <input type="text" id="useraccountNumber" name="accountNumber" 
               placeholder="Enter Your Account number">
        <input type="button" onclick="checkAccountnumber()" value="submit">
    </form>
    <script type="text/javascript">
    function CheckAmount() {
        var money = Number(document.getElementById("useramount").value);
        if (money >= 0) {
            document.getElementById("transferAmount").value = money;
            document.getElementById("amountContainer").style.display = "none";
            document.getElementById("accountContainer").style.display = "block";
        } else {
            alert("Invalid Amount");
        }
    }
    function checkAccountnumber(){
        var useraccountNumber = document.getElementById("useraccountNumber").value;
        var accountNumber = document.getElementById("Accountnumber").value;
        
        if(useraccountNumber == accountNumber){
            document.getElementById("accountContainer").submit();
        } else {
            alert("Invalid Account number");
        }
    }
    </script>
    <%
    String Amount = request.getParameter("Amount");
    String accountNumber = request.getParameter("accountNumber");

    if(Amount != null && accountNumber != null){
        try {
            int amount = Integer.parseInt(Amount);
            long account = Long.parseLong(accountNumber);
            RegistrationDAO dao = new RegistrationDAOimpl();
            
            int credit = dao.creditbyuseingAccountnumber(amount, account);
            if(credit != 0){ 
                alluserdetails.setAmount(alluserdetails.getAmount() + amount);       
                response.sendRedirect("UserHome.jsp");
                return;
            } else {
                response.sendRedirect("credit.jsp?");
                return;
            }
        } catch(NumberFormatException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace(); 
        }
    }
    %>
</body>
</html>