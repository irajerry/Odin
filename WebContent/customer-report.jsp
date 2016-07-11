<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>	




<div class="container">

<h1 class="page-header"> Customer Information</h1>
<table class="table">

<tr>
<th>  ID  # </th>
<th>  First Name </th>
<th>  Last Name </th>
<th> Billing Address </th>
<th> Email Address </th>
<th> Company </th>
<th> Phone Number </th>
</tr>


<tr>
<td> <c:out value="${customer.customerID }"/></td>
<td> <c:out value="${customer.firstname }"/></td>
<td> <c:out value="${customer.lastname }"/></td>
<td> <c:out value="${customer.address }"/></td>
<td> <c:out value="${customer.emailAddress }"/></td>
<td> <c:out value="${customer.company}"/></td>
<td> <c:out value="${customer.phoneNumber }"/></td>
</tr>






</table>



</div>



<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>