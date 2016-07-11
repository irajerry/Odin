<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="includes/errorpg.jsp" %> 
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	



<c:if test="${user.role !=  'ADMIN'}"> 
<c:redirect url="login.jsp"></c:redirect>
</c:if>


<h1 class='page-header'>Search for Customers</h1>

<div class="frm1">
<a href="CustomerReports?action=ALL" > <button class="btn btn-primary"> Search ALL Customers </button></a>

</div>


<div class="frm2">

<form action="CustomerReports" method="get" class="form-inline">
<input type="hidden" name="action" value="ID">
<label for="custID">Enter Customer ID
<input type="text" name="customer_id" class="form-control" id="custID"> </label>
<button class="btn btn-primary">Find Customer</button>



</form>


</div>



<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>