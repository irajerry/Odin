<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="includes/head.jsp" %>
<%@ include file="includes/header.jsp" %>


 




<div>
<div class="mainbanner">
<div id="full-screen-slider">
      <ul id="slides" class="slides">
<li style="background: url(pic/pic1.jpg) no-repeat center top;height:300px;"><a href="ProductServlet?action=CATEGORY&type=BUSINESS" target="_blank" title="ad1"></a></li>
<li style="background: url(pic/pic2.jpg) no-repeat center top;height:300px;"><a href="ProductServlet?action=CATEGORY&type=PERSONAL" target="_blank" title="ad2"></a></li>
<li style="background: url(pic/odin.jpg) no-repeat center top;height:300px;"><a href="#" target="_blank" title="ad3"></a></li>
      </ul>
      <ul id="pagination">
 	<li class="current"></li>
<li></li>
<li></li>
      </ul>
    </div>
</div>
</div>

<div class="h">
<h2>Why Choose Us?</h2>
<ul>
<li>We are offering a cloud based internet security software solution that allows our clients to pick and choose features they want and is offered in the form of a subscription.</li>
<li>We give the customers a fully control on what they want to install to protect their computer system.</li>
<li>We eliminate the complex processes of uninstalling unwanted softwares from their computer by unscribing our products.</li>
<li>We provide 30 days free trial of our products.</li>
</ul>
</div>




<script src="js/jquery-1.11.2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/query.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="js/slide2.js" type="text/javascript"></script>


<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>

