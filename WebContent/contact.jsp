<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/includes/head.jsp" %>
<link href="/OdinSecurity/contact.css" rel="stylesheet" type="text/css">
</head>
<%@ include file ="/includes/header.jsp" %>





<div id="margin">
<div id="comment">
<p><strong>We appreciate your comment!^^</strong></p>
<form method="post" action="" onSubmit="return checkmyform();">
  <label for="myFirstName">* First Name</label>
  <input type="text" name="myFirstName" id="myFirstName" placeholder="your first name">
  <label for="myLastName">* Last Name</label>
  <input type="text" name="myLastName" id="myLastName" placeholder="your last name">
  <label for="myEmail">* E-mail</label>
  <input type="email" name="myEmail" id="myEmail" placeholder="you@yourdomain.com">
   <label>Do you find this website helpful?</label>
    Yes<input type="checkbox" name="accept" >
    No <input type="checkbox" name="accept" >
   <label for="myComments">* Comments</label>
  <textarea name="myComments" id="myComments" rows="4" cols="40" placeholder="your comments here"></textarea>
  <input type="submit" value="Submit">
</form>
</div>

<div id="div">
<h1>Welcome to contact us!</h1>
<p><strong>Thank You</strong> for your interest in our website.<br> 
Please feel free to contact us by either submitting the comment form or directly sending email to us.  </p>
  
      <h5>Email: <br><a href="mailto:shuangling.zhen@baruchmail.cuny.edu">Shuangling Zhen</a><br>
      <a href="mailto:peixin.wang@baruchmail.cuny.edu">Peixin Wang</a><br>
      <a href="mailto:jesse.maggiore@baruchmail.cuny.edu">Jesse Maggiore</a><br>
      <a href="mailto:Ira.Jerry@baruchmail.cuny.edu">Ira Jerry</a><br>
      </h5>
      </div>
</div>

<%@ include file="/includes/jsdefaults.jsp" %>
<%@ include file ="/includes/footer.jsp" %>
