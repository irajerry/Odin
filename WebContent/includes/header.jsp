<body style="padding-top: 70px">
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
    <c:if test="${user.role ==null}">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#topFixedNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
      <a href="index.jsp"><img src="pic/logo.jpg" height="50"></a></c:if>
     <c:if test="${user.role == 'CUSTOMER' }">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#topFixedNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
      <a href="dashboard.jsp"><img src="pic/logo.jpg" height="50"></a></c:if>
     <c:if test="${user.role == 'ADMIN'}">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#topFixedNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
      <a href="admin.jsp"><img src="pic/logo.jpg" height="50"></a>
     </c:if>
      
     
      
      </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="topFixedNavbar1">
      <ul class="nav navbar-nav">
		<c:if test="${ user.role != 'ADMIN' }">
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Product<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="ProductServlet?action=CATEGORY&type=BUSINESS">Business</a></li>

            <li><a href="ProductServlet?action=CATEGORY&type=PERSONAL">Personal</a></li>

          </ul>
        </li>
        <li><a href="#">About</a></li>
        <li><a href="/OdinSecurity/contact.jsp">Contact Us</a></li>
      </ul>
      </c:if>
      
      <c:if test="${user.role == 'ADMIN'}">
      <ul class="nav navbar-nav">
       <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Product<span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="ProductServlet?action=GETALL">Edit Products</a></li>
            <li><a href="addProduct.jsp">Add Product</a></li>
          </ul>
          
        </li>
        <li><a href="SaleReport">Sales Reports</a></li>
        <li><a href="customer.jsp">Customer Report</a></li>
     	<li><a href="orders.jsp">Orders Report</a>
      
      </ul>
      </c:if>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <c:if test="${user == null}">
			<li><a href="/OdinSecurity/register.jsp">New User</a></li>
			<li><a href='/OdinSecurity/login.jsp'>Login</a></li>
		</c:if> 
        <c:if test="${user !=Null }">
		<li><a href="/OdinSecurity/logoff.jsp"> Log Off</a></li>
		</c:if>
      
      </ul>
    </div>
    <!-- /.navbar-collapse -->
  </div>
  <!-- /.container-fluid -->
</nav>

<%-- <c:if test="${user !=null & user.role }">

<%@ include file="../includes/user.jsp" %></c:if> --%>
