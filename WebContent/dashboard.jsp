<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	
<body>
<c:if test="${user == null }"> <c:redirect url="/login.jsp"></c:redirect></c:if>



<%@ include file="includes/nav.jsp" %>	


<div class="info">
<h1>Welcome back! <c:out value="${user.firstname}"/></h1>
<p>Use the menu to the left to access your account information, you can view order history as well as active inactive subscriptions.</p>
</div>







<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>