<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<link href="register.css" rel="stylesheet" type="text/css">
<script src="form.js" type="text/javascript"></script>

</head>

<%@include file="includes/header.jsp" %>
<div class="container">
<div class="Payment-Form">
<h2><strong>Create New Account</strong></h2>
<p id="p">with * is must fill in</p>
<form method="post" action="RegistrationServlet" onSubmit="return checkmyform();" id="registerForm" >
   <label for="username">* Username: </label>       
   <input type="text" name="username" class="form-control" placeholder="Enter your Username！" id="username">
   <label for="password">* Password: </label>
   <input type="password" name="password" class="form-control" placeholder="Enter your password！" id="password">
  <label for="myFirstName"> First Name: </label>
  <input type="text" name="firstname" id="firstname" class="form-control" placeholder="your first name">
  <label for="myLastName">Last Name: </label>
  <input type="text" name="lastname" id="lastname" class="form-control" placeholder="your last name">
  <label for="myEmail">* E-mail: </label>
  <input type="email" name="email" class="form-control" placeholder="you@yourdomain.com" id="email">
  <label for="address">* Address: </label>
  <input type="text" name="address" id="address"  class="form-control" placeholder="Street, apt#">
  <label for="city">* City: </label>
  <input type="text" name="city" id="city"  class="form-control" placeholder="City">
  <label for="state">* State: </label>
  <input type="text" name="state" id="state"   class="form-control" placeholder="State">
  <label for="zip">* Zipcode: </label>
  <input type="number" name="zip" id="zip" class="form-control" placeholder="Zipcode">
  <label for="phone">* Phone: </label>
  <input type="tel" name="phone" id="phone"  class="form-control" placeholder="Phone number">
  <input id="submit" type="submit" value="Register" class="btn btn-primary">
</form>
</div>
</div>
<%@include file="includes/jsdefaults.jsp" %>
<%@include file="includes/footer.jsp" %>
