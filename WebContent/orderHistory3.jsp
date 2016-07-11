<%@include file="/includes/head.jsp" %>
<%@ include file ="/includes/header.jsp" %>




<%-- <c:if test="${param.userID != user.customerID}">
<c:redirect url="OrderHistory?userID=${user.customerID }"></c:redirect>
</c:if> --%>

<div class="container">


<h1 class="page-header"> Order History</h1>
<table class="order-history">
<tr>
<th> Order # </th>
<th> Order Date </th>
<th> Item Number </th>
<th> Total </th>
</tr>



<tr>
<td> <c:out value="${order.orderId}"></c:out></td>
<td> <c:out value="${order.orderDate}"></c:out></td>
<td> <c:out value="${order.orderItem}"></c:out></td>
<td> <c:out value="${order.total }"/></td>


</tr>


</table>
</div>

<%@ include file="/includes/jsdefaults.jsp" %>
<%@ include file ="/includes/footer.jsp" %>