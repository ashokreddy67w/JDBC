<%@page import="com.org.modal.costumaerdetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banking Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('path-to-your-image.png'); /* Replace with your image path */
            background-size: cover;
            background-position: center;
            color: #fff;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        .container {
            background-color: rgba(0, 0, 0, 0.6);
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            width: 300px;
        }
        h2 {
            color: #ffd700;
        }
        h6 {
            color: #ffd700;
        }
        button, input[type="submit"] {
            background-color: #008cba;
            color: white;
            padding: 10px 20px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover, input[type="submit"]:hover {
            background-color: #005f73;
        }
        form {
            margin: 10px 0;
        }
        a {
            color: #ffd700;
            text-decoration: none;
            display: block;
            margin-top: 20px;
        }
        a:hover {
            text-decoration: underline;
        }
        input {
            padding: 10px;
            margin: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            width: 90%;
        }
        p {
            color: red;
        }
        .name-overlay {
            font-size: 24px;
            color: #ffd700;
            font-weight: bold;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
            color: black;
        }
    </style>
</head>
<body>

<% costumaerdetails alluserdetails = (costumaerdetails) session.getAttribute("alluserdetails");

if (alluserdetails != null) { %>
    <div class="name-overlay">
        Welcome, <%= alluserdetails.getName() %>
    </div>
<% } %>

    <div class="container">
        <h2>Banking Home</h2>
        <form action="credit.jsp">
            <button>Credit</button>
        </form>
        <form action="debit.jsp">
            <button>Debit</button>
        </form>
        <form action="CheckBalance.jsp">
            <button>Check Balance</button>
        </form>
        
        <a href="Stetament.jsp">
            <button>Statement</button>
            </a>
        
        <a href="#">Learn More About Our Services</a>
    </div>

   
</body>
</html>