
<c:set value="<%=new java.util.Date()%>" var="now"/>	
<div class="userInfo">
User: <c:out value="${user.username.toUpperCase() }"/><br/>
Date: <fmt:formatDate type="both" value="${now}" />
</div>