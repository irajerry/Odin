<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	

<c:if test="${user.role !='ADMIN' }"> <c:redirect url="/login.jsp"></c:redirect></c:if>






 <div class="info">
<h1> Welcome to Administration Portal, <c:out value="${user.firstName }"/></h1>

	
	<p> Welcome to the administration portal you can run reports using the navigation bar above </p>
	
	</div>








<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>

