<%@ include file="includes/head.jsp" %>
<link href="product.css" rel="stylesheet" type="text/css">
</head>
<%@ include file="includes/header.jsp" %>

	<div class="products">



	
	<c:forEach items="${products}" var="products">
		<div class="box">
			<c:if test="${products.type == 'PERSONAL' }">
  			<img src="pic/PRODUCT.png" width="200">
  			</c:if>
  			<c:if test="${products.type == 'BUSINESS'}">
  			<img src="pic/PRODUCT2.png" width="200">
  			</c:if>
  			 <a href="ProductServlet?productID=${products.productID}&action=EDIT"><br/>
  			  <span>${products.productName} - $  ${products.price} </span>
  			  </a>
  			  
		</div>
	</c:forEach>

</div>		
<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>