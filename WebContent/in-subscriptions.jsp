<%@include file="/includes/head.jsp" %>
<%@ include file ="/includes/header.jsp" %>



<c:if test="${param.customer_id != user.customerID}">
<c:redirect url="ViewSubcriptions?customer_id=${user.customerID }&action=INACTIVE"></c:redirect>
</c:if>

<%@ include file="includes/nav.jsp" %>	
<div class="container">
<h1> Inactive Subscriptions</h1>
<table class="order-history">
<tr>
<th> Order # </th>
<th>Item Number </th>
<th>Start Date	</th>
<th> Expire Date</th>
<th> Subscription Number </th>
</tr>

<c:forEach items="${subs}" var="subs">
<tr>
<td> <c:out value="${subs.orderid}"></c:out></td>
<td> <c:out value="${subs.itemNumber}"></c:out></td>
<td> <c:out value="${subs.startDate }"/></td>
<td> <c:out value="${subs.expireDate }"></c:out> </td>
<td> <c:out value="${subs.id }"></c:out> </td>
</tr>
</c:forEach>

	
</table>

</div>
<%@ include file="/includes/jsdefaults.jsp" %>
<%@ include file ="/includes/footer.jsp" %>