<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	
<body>
<c:if test="${user ==null }"> <c:redirect url="/login.jsp"></c:redirect></c:if>


<%@ include file="includes/nav.jsp" %>	
userID : <c:out value="${user.customerID }"/>
<div class="center">
<h1><c:out value="${user.firstname }"/>, Edit Your Profile Below</h1>
</div>

<div class="container">
<div class="Payment-Form">
<form method="post" action="LoginServlet" onSubmit="return checkmyform();">
  <input type="hidden" name="custID" value="${user.customerID}"/>
  <input type="hidden" name="action" value="update" >
  <label for="myFirstName">* First Name: </label>
  <input type="text" name="myFirstName" id="myFirstName" value="${user.firstname}"placeholder="your first name" required  class="form-control">
  <label for="myLastName">* Last Name: </label>
  <input type="text" name="myLastName" id="myLastName" value="${user.lastname}"placeholder="your last name" required class="form-control">
  <label for="myEmail">* E-mail: </label>
  <input type="email" name="myEmail" id="myEmail" value="${user.emailAddress}" placeholder="you@yourdomain.com" required class="form-control">
  <label for="address">* Address: </label>
  <input type="text" name="address" id="address"value="${user.address}" placeholder="Street, apt#" required class="form-control">
  <label for="phone">* Phone: </label>
  <input type="tel" name="phone" id="phone" value="${user.phoneNumber}" placeholder="Phone number" required class="form-control"><br>
  <label for="company">* Company: </label>
  <input type="tel" name="company" id="phone" value="${user.company}" placeholder="Company" required class="form-control"><br>
  <input  type="submit" value="Update" class="btn btn-success">
</form>
</div>


</div>	
<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>