<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<link href="log in.css" rel="stylesheet" type="text/css">
</head>
<%@ include file ="includes/header.jsp" %>





<div class="page-container">
<h2><c:out value="${messsage.toString() }"/></h2>
            <h1>Login</h1>
            <form action="LoginServlet" method="post" class="form">
            	<label for="username">User Name : </label>        
                <input type="text" name="username" class="form-control" placeholder="Enter your Username" required>
                <label for="password">Password: </label>
                <input type="password" name="password"  class="form-control" placeholder="Enter your password" required><br>
                <div class="radio">
                <label class="radio-inline"> <input type="radio" name="action" value="CUSTOMERLOGIN" checked>Customer</label>
                </div>
                <div class="radio">
                <label class="radio-inline"> <input type="radio" name="action" value="ADMINLOGIN"> Administrator </label>
                </div>
                <button id="submit" type="submit" class="btn btn-success">Login</button>
            </form>
            <div class="forgot">
            Forget Password? <a href="#">Reset Password</a><br>
            Don't have a account? <a href="/OdinSecurity/register.jsp">Register</a>
            </div>
   </div>


<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file ="includes/footer.jsp" %>
