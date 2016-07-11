<%@ include file="includes/head.jsp" %>

<body>
<%@ include file="includes/header.jsp" %>
<c:if test="${ user ==null }"> <c:redirect url="login.jsp"></c:redirect></c:if>

<div class="payment">
<h1> Purchase</h1>

	<form action="ProcessPayment" method="post" class="Payment-Form" id="payment-form">
		<input type="hidden" value="${item}" name="product" >
		<input type="text" placeholder="First Name" name="firstName" class="form-control" value="${user.firstname }"><br/>
		<input type="text" placeholder="Last Name" name="lastName" class="form-control" value="${user.lastname }">	<br/>
		<input type="text" placeholder="Billing Address" name="billingAddressStreet" class="form-control"  value="${user.address }"><br/>
		<input type="text" placeholder="City" name="billingAddressCity" class="form-control"><br/>
		<input type="text" placeholder="Zip Code" name="billingZip" class="form-control"><br/>
		<input type="text" placeholder="Credit Card Number" name="creditcardnum" class="form-control"><br/>
		<select id="expDate" name="expirationDate">
			<option value="01"> Jan </option>
			<option value="02"> Feb </option>
			<option value="03"> Mar</option>
			<option value="04"> Apr </option>
			<option value="05"> May </option>
			<option value="06"> Jun </option>
			<option value="07"> Jul </option>
			<option value="08"> Aug </option>
			<option value="09"> Sep </option>
			<option value="10"> Oct </option>
			<option value="11"> Nov</option>
			<option value="12"> Dec </option>
		</select>
		<select id="expYear" name="expirationYear">
			<option value="2016"> 2016 </option>
			<option value="2017"> 2017 </option>
			<option value="2018"> 2018 </option>
			<option value="2019"> 2019 </option>
			<option value="2020"> 2020 </option>
			<option value="2021"> 2021 </option>
			<option value="2022"> 2022 </option>
		
		</select><br/><br/>
			<button type="submit" class="btn btn-success">Submit</button>
			
	</form>
</div>


<%@ include file="includes/jsdefaults.jsp" %>
<%@ include file="includes/footer.jsp" %>
</body>
</html>