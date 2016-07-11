<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	



<c:if test="${user.role !=  'ADMIN'}"> 
<c:redirect url="login.jsp"></c:redirect>
</c:if>


<h1 class='page-header'>Search for Customers</h1>

<div class="frm1">
<a href="OrderHistory?action=ALL" > <button class="btn btn-primary"> Search ALL Orders </button></a>

</div>


<div class="frm2">

<form action="OrderHistory" method="get" class="form-inline">
<input type="hidden" name="action" value="ID">
<label for="orderID">Enter Order Number
<input type="text" name="order_number" class="form-control" id="orderID"> </label>
<button class="btn btn-primary">Find Order</button>



</form>


</div>



<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>