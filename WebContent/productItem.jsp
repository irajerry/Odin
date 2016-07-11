<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="includes/head.jsp"%>
<link href="product.css" rel="stylesheet" type="text/css">
</head>
<%@ include file="includes/header.jsp" %>
<c:forEach items="${product}" var="product">
<div>

 <div class="div">
	<c:if test="${product.type == 'PERSONAL' }">
  			<img src="pic/PRODUCT.png" width="300">
  			</c:if>
  			<c:if test="${product.type == 'BUSINESS'}">
  			<img src="pic/PRODUCT2.png" width="300">
  			</c:if>
</div>


<h1>2016 - <c:out value="${product.productName}"/></h1>

<p>Price:<c:out value="${product.price}"/></p><br>
<p>Type:<c:out value=" ${product.type}"/></p>
<p class="p">Feature:</p>
<ul>
<li>Easy Installation</li>
<li>Easy to Un-install</li>
<li>Enhance your Firewall</li>

</ul>	

Product detail:<br><c:out value="${product.productDesc}"/><br/>
<c:set var="item" value="${product.productID}" scope="session" 	/>

<a href='order.jsp?productID=<c:out value="${product.productID}"></c:out>'>

<button type="submit" class="btn btn-primary">Place Order</button></a>
</div>	

</c:forEach>
<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>