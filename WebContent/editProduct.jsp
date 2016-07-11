<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	



<c:if test="${user.role !=  'ADMIN'}"> 
<c:redirect url="login.jsp"></c:redirect>
</c:if>


<h1 class='page-header'>Edit Product </h1>



<div class="container">



<form action="ProductServlet" method="get" class="Payment-Form">
<input type="hidden" name="action" value="EDITPRODUCT">
<input type="hidden" name="productID" value="${product.productID }">
<label for="productname">Enter Product Name
<input type="text" name="productName" class="form-control" id="productname" value="${product.productName }"> </label><br/>
<label for="description">Enter Description
<input type="text"  name="description" class="form-control" id="description" value="${product.productDesc }">
</label><br/>
<label for="price">Enter Price
<input type="text" name="price" class="form-control" id="price" value="${product.price }"> </label>
<div class="form-group">
<strong> Product Coverage</strong>
<div class="radio">
<label class="radio-inline" for="FULL">
<input type="radio" name="coverage" id="FULL"  value="FULL"> FULL</label>
</div>

<div class="radio">
<label class="radio-inline" for="DESKTOP">
<input type="radio" name="coverage" id="DESKTOP" value="INTERNET">DESKTOP
</label>
</div>

<div class="radio">

<label class="radio-inline" for="INTERNET">
<input type="radio" name="coverage"  id="INTERNET" value="DESKTOP">INTERNET
</label>
</div>
</div>

<div class="form-group">
<strong>Product Type</strong>
	<div class="radio">
	<label class="radio-inline" for="PERSONAL">
	<input type="radio" name="productType" id="PERSONAL"  value="PERSONAL">Personal
	 </label>
	</div>
	
	<div class="radio">
	<label class="radio-inline" for="BUSINESS">
	<input type="radio" name="productType" id="BUSINESS" value="BUSINESS">Business
	</label>
	</div>
	
	
</div>


<div class="select">
<label for="platform">Platform

<select name="platform" class="form-control" id="platform" value="${product.platform }"> 
 <option value ="WINDOWS">Windows </option>
 <option value ="LINUX">Linux </option>
 <option value ="MAC">MAC OS </option>
 <option value ="ANDROID">Android </option>
 <option value ="IPHONE">IOS </option>
</select>

</label>
</div>
<br/>
<input type="submit" class="btn btn-primary" value="Edit Product">



</form>

</div>



<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>