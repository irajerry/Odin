<%@include file="/includes/head.jsp" %>
<%@ include file ="/includes/header.jsp" %>



<c:if test="${param.customer_id != user.customerID}">
<c:redirect url="ViewSubcriptions?customer_id=${user.customerID }&action=ACTIVE"></c:redirect>
</c:if>
<%@ include file="includes/nav.jsp" %>	

<div class="container">
<h1> Active Subscriptions</h1>
<table class="order-history">
<tr>
<th scope="col"> Order # </th>
<th scope="col"> Item Number </th>
<th scope="col">Start Date	</th>
<th scope="col"> Expire Date</th>
<th scope="col"> Subscription Number </th>
<th scope="col"> Unsubscribe</th>
</tr>

<c:forEach items="${subs}" var="subs">
<tr>
<td> <c:out value="${subs.orderid}"></c:out></td>
<td> <c:out value="${subs.itemNumber}"></c:out></td>
<td> <c:out value="${subs.startDate }"/></td>
<td> <c:out value="${subs.expireDate }"></c:out> </td>
<td> <c:out value="${subs.id }"></c:out> </td>
<td> <a href="SubcriptionsServlet?order_id=${subs.orderid}">  <button class="btn btn-danger" id="Button1">Unsubscribe
</button></a></td>

</tr>
</c:forEach>

	
</table>
</div>
<%@ include file="/includes/jsdefaults.jsp" %>
<%@ include file ="/includes/footer.jsp" %>