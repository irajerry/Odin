<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	



<c:if test="${user.role !=  'ADMIN'}"> 
<c:redirect url="login.jsp"></c:redirect>
</c:if>


<h1 class='page-header'>Add Product </h1>



<div class="product-form">


<form action="ProductServlet" method="get" class="">
<input type="hidden" name="action" value="ADDPRODUCT">
<label for="productname">Enter Product Name
<input type="text" name="productName" class="form-control" id="productname"> </label><br/>
<label for="description">Enter Description
<textarea cols="100" rows="5" name="description" class="form-control" id="description"> </textarea>
</label>
<label for="price">Enter Price
<input type="text" name="price" class="form-control" id="price"> </label>
<div class="form-group">
<strong> Product Coverage</strong>
<div class="radio">
<label class="radio-inline" for="FULL">
<input type="radio" name="coverage" id="FULL"  value="FULL"> </label>FULL
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

<select name="platform" class="form-control" id="platform"> 
 <option value ="WINDOWS">Windows </option>
 <option value ="LINUX">Linux </option>
 <option value ="MAC">MAC OS </option>
 <option value ="ANDROID">Android </option>
 <option value ="IPHONE">IOS </option>
</select>

</label>
</div>

<br/>








<input type="submit" class="btn btn-primary" value="Add Product">



</form>

</div>



<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>