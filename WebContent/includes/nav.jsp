

<div id="navigation">
<ul class="col-xs-12">
	<li><a href="dashboard.jsp">Dashboard</a></li>
    <li><a href="OrderHistory?userID=${user.customerID}&action=CUSTOMER"> View Order History </a></li>
    <li><a href="ViewSubcriptions?customer_id=${user.customerID }&action=ACTIVE">View Active Subscriptions</a></li>
    <li><a href="ViewSubcriptions?customer_id=${user.customerID }&action=INACTIVE"> View Inactive Subscriptions</a></li>
    <li><a href="LoginServlet?userID=${user.customerID }">Edit Profile</a></li>
    <li><a href="logoff.jsp">Logout</a></li>    
</ul>
</div>
