<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="includes/errorpg.jsp" %> 
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>


 <script>
	var sales = [[
	              <c:forEach var="totals" items="${totals}" varStatus="i">
		
	
				[ <c:out value="${i.index}"/>, <c:out value="${totals}"/> ],
					</c:forEach> 
	                ]];
	
	var dates = [
	              <c:forEach var="dates" items="${dates}" varStatus="status">
	              [<c:out value="${status.index}"/>,"<fmt:formatDate type="date" 
	               value="${dates}" />"],
			        </c:forEach>
	              	];

		window.onload = function(){
		Flotr.draw(document.getElementById("chart"),
				sales,
				{
				title: "Daily Sales in USD",
				
			 	bars:{
			 		show:true,
			 		barwidth:.25
					 	},
					 	
				yaxis:{
					min:0,
					
				},
				xaxis:{
					ticks: dates
					
				},
			
				grid: {
					horizontalLines: true,
					verticalLines: false
					
				},
				 	}
		);
	};
</script>
 
<!--  
 <script>
	var sales = [
	              <c:forEach var="totals" items="${totals}" varStatus="i">
		
	
				[ <c:out value="${i.index}"/>, <c:out value="${totals}"/> ],
					</c:forEach> 
	                ];
	
	var dates = [
	              <c:forEach var="dates" items="${dates}" varStatus="status">
	              [<c:out value="${status.index}"/>,"<fmt:formatDate type="date" 
	               value="${dates}" />"],
			        </c:forEach>
	              	];

		window.onload = function(){
		Flotr.draw(document.getElementById("chart"),
				[{data :sales, lines:{show:true}}]
				);
		};
</script> -->


<div id="chart" style="width:600px; height:300px;">


</div>

<div class="info">
<span class="badge">Number of Customers: <c:out value="${dashboard['customers']}"/></span>
<span class="badge">Number of Active Subscriptions: <c:out value="${dashboard['active']}"/></span>
<span class="badge">Number of Cancelled Subscriptions: <c:out value="${dashboard['inactive']}"/></span>
<span class="badge">Number of Orders: <c:out value="${dashboard['orders']}"/></span>
<span class="badge">Total Sales : $  <c:out value="${dashboard['sales']}"/></span>

</div>
<script src="flotr2.min.js"></script>
<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
