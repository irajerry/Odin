<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*, java.io.*, java.lang.*" isErrorPage="true" contentType="text/html; charset=utf-8"%>
<%@ page isErrorPage="true" %>
<%@include file="includes/head.jsp"%>
<%@ include file="includes/header.jsp" %>


<h1 class="page-header">Search Error</h1>

<%{
if(exception instanceof java.lang.ClassNotFoundException){
%>
<p><strong>The application is unable to locate the file.</strong></p>
<%
}else if(exception instanceof java.sql.SQLException){
%>
<p>The application is unable to connect to the database.</p>

<%
}else if (exception instanceof java.lang.NullPointerException){
%>
<p> <strong>The application is unable to locate the file.</strong></p>
<%
}else{
%>
 
 <h1><font color="red"> Opps.. An search error occurred. </font></h1>
	<p> Please Make Sure you select a semester to search </p>
<%
}
}
%>

<a href="dashboard.jsp"> Return to Home</a>
<%@ include file="includes/jsdefaults.jsp" %>
<%@include file="includes/footer.jsp"%>
		