<%@include file="/includes/head.jsp" %>
<%@ include file ="/includes/header.jsp" %>
<%@ page errorPage="includes/errorpg.jsp" %> 


<h2 class="deleted" ><c:out value="${msg}"></c:out></h2><br/>


<c:if test="${param.userID != user.customerID}">
<c:redirect url="OrderHistory?userID=${user.customerID }&action=CUSTOMER"></c:redirect>
</c:if>
<%@ include file="includes/nav.jsp" %>
<div class="container">
	

<h1 class="page-header"> Order History</h1>
<table class="order-history">
<tr>
<th> Order # </th>
<th> Order Date </th>
<th> Item Number </th>
<th> Total </th>
</tr>


<c:forEach items="${order}" var="order">
<tr>
<td> <c:out value="${order.orderId}"></c:out></td>
<td> <c:out value="${order.orderDate}"></c:out></td>
<td> <c:out value="${order.orderItem}"></c:out></td>
<td> <c:out value="${order.total }"/></td>
</tr>
</c:forEach>


</table>
</div>

<%@ include file="/includes/jsdefaults.jsp" %>
<%@ include file ="/includes/footer.jsp" %>